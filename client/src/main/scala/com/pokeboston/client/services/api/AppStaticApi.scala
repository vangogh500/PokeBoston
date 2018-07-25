package com.pokeboston.client
package services
package api

object AppStaticApi {
  def getUrlForImg(img: String) = "http://localhost:9000/assets/img/" + img
}
