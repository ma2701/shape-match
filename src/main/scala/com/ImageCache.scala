package com

import java.awt.image.BufferedImage
import javax.imageio.ImageIO

import scala.util.Try

class ImageCache {
    private[this] val cache = scala.collection.mutable.HashMap.empty[String, BufferedImage]

    def load(fileName: String): Option[BufferedImage] =
        cache.get(fileName) match {
            case Some(n) => Some(n)
            case None    =>
                def loadedImage = Try {
                    ImageIO.read(getClass.getResourceAsStream(fileName))
                }.map { bufferedImage =>
                    cache += (fileName -> bufferedImage)
                    bufferedImage
                }

                loadedImage.toOption
        }

    def loadOrThrow(fileName: String): BufferedImage =
        load(fileName).getOrElse(throw new MissingImageException(s"image ${fileName} is missing"))

    def cachedImageCount = cache.size

    def bust: Unit = cache.clear()

}

class MissingImageException(msg:String) extends Exception(msg)
