package com.pokeboston.client
package scenes
package auth
package lib

import com.pokeboston.client.lib.Logo._

package object passports {
  sealed trait AuthPassport {
    def logo: AppLogo
  }
  sealed trait AppPassport extends AuthPassport
  sealed trait SocialMediaPassport extends AuthPassport
  case object EmailPassport extends AppPassport {
    def logo = CssLogo("mdi-email")
  }
  case object SMSPassport extends AppPassport {
    def logo = CssLogo("mdi-cellphone-android")
  }
  case object FacebookPassport extends SocialMediaPassport {
    def logo = UrlLogo("https://upload.wikimedia.org/wikipedia/commons/f/ff/Facebook_logo_36x36.svg")
  }
  case object TwitterPassport extends SocialMediaPassport {
    def logo = UrlLogo("https://upload.wikimedia.org/wikipedia/fr/c/c8/Twitter_Bird.svg")
  }
  case object GooglePassport extends SocialMediaPassport {
    def logo = UrlLogo("https://upload.wikimedia.org/wikipedia/commons/5/53/Google_%22G%22_Logo.svg")
  }
  case object MicrosoftPassport extends SocialMediaPassport {
    def logo = UrlLogo("https://upload.wikimedia.org/wikipedia/commons/5/5f/Windows_logo_-_2012.svg")
  }
  val passports = Seq(EmailPassport, SMSPassport, FacebookPassport, TwitterPassport, GooglePassport, MicrosoftPassport)
  val (appPassports, socialMediaPassports) = passports.partition(p => p.isInstanceOf[AppPassport])
}
