package de.htwg.se.muehle

import com.google.inject.AbstractModule
import com.google.inject.name.Names
import net.codingwell.scalaguice.ScalaModule
import de.htwg.se.muehle.controller.controllerComponent._
import de.htwg.se.muehle.model.gridComponent.{IGrid, gridBaseImpl}
import de.htwg.se.muehle.model.fileIOImpl._


class MuehleModule extends AbstractModule with ScalaModule {

  def configure() = {
    bindConstant().annotatedWith(Names.named("Init")).to(true)
    bindConstant().annotatedWith(Names.named("Fields")).to(24)
    bind[IController].to[controllerBaseImpl.Controller]
    bind[IGrid].to[gridBaseImpl.Grid]
    bind[FileIOInterface].to[jsonImpl.FileIO]
  }
}
