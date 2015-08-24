package com

class ApplicationDeath extends Runnable {
    private val WAIT_TIME_BEFORE_SYSTEM_EXIT_CALLED = 500

    override def run(): Unit = {
        Thread.sleep(WAIT_TIME_BEFORE_SYSTEM_EXIT_CALLED)
        System.exit(0)
    }
}
