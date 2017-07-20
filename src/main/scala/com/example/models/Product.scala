package com.example.models

case class Product(
                    name: String,
                    quantity: Int,
                    payblePrice: Double = 0,
                    deliveryGuy: String = "Unassigned",
                    estimatedDeliveryDate: String = "Unassigned"
                  )
