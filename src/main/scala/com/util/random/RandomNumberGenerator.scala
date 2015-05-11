package com.util.random

import java.util.Random

import scala.annotation.tailrec

object RandomNumberGenerator {
    val random: Random = new Random()

    def next(range: Range): Int = {
        random.nextInt(range.max - range.min + 1) + range.min
    }

    def nextNNumbers(n: Int, range: Range): Seq[Int] = List.tabulate(n) { i => next(range) }
    
    def nextNDistinct(n: Int, range: Range): Set[Int] = {

        @tailrec
        def generate(n: Int, acc: Set[Int]): Set[Int] = {
            if (n == 0) return acc
            else {
                val newSet = acc + next(range)

                generate(n - (newSet.size - acc.size), newSet)
            }
        }

        generate(n, Set.empty)
    }

}

