package com.example.myapplication.utils

data class LaptopBuilder(val builder: Builder) {
    private val processor: String = builder.processor
    private val ram: String = builder.ram
    private val battery: String = builder.battery
    private val screenSize: String = builder.screenSize

    // Builder class
    class Builder(processor: String) {
        var processor: String = processor // this is necessary

        // optional features
        var ram: String = "2GB"
        var battery: String = "5000MAH"
        var screenSize: String = "15inch"

        fun setRam(ram: String): Builder {
            this.ram = ram
            return this
        }

        fun setBattery(battery: String): Builder {
            this.battery = battery
            return this
        }

        fun setScreenSize(screenSize: String): Builder {
            this.screenSize = screenSize
            return this
        }

        fun create(): LaptopBuilder {
            return LaptopBuilder(this)
        }
    }
}