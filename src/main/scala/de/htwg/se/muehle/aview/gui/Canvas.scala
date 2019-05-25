package de.htwg.se.muehle.aview.gui

import java.awt.{BasicStroke, Color, Graphics2D}

import scala.swing._

class Canvas extends Panel{
  val BACKCOLOR = new Color(200,200,100)
  def drawGrid(g: Graphics2D, gap:Int, size:Int) = {
    for (r <- 1 to size) {
      val t:Int = gap*r
      g.drawLine(t,0,t, this.size.height)
      g.drawLine(0,t,this.size.width,t)
    }
  }
  def drawCircleGrid(g:Graphics2D, offset:Int, length:Int, gap:Int)= {
    var w_off = offset
    var h_off = offset
    for (r <- 0 to 6) {
      r match {
        case 0 | 6 => {
          for (m <- 0 :: 3 :: 6 :: Nil) {
            w_off = offset + gap * m
            h_off = offset + gap * r
            drawCircle(g, h_off, w_off, length)
          }
        }
        case 1 | 5 => {
          for (m <- 1 :: 3 :: 5 :: Nil) {
            w_off = offset + gap * m
            h_off = offset + gap * r
            drawCircle(g, h_off, w_off, length)
          }
        }
        case 2 | 4 => {
          for (m <- 2 :: 3 :: 4 :: Nil) {
            w_off = offset + gap * m
            h_off = offset + gap * r
            drawCircle(g, h_off, w_off, length)
          }
        }
        case 3 => {
          for (m <- 0 :: 1 :: 2 :: 4 :: 5 :: 6 :: Nil) {
            w_off = offset + gap * m
            h_off = offset + gap * r
            drawCircle(g, h_off, w_off, length)
          }
        }
      }
    }
  }

  def drawCircle(g: Graphics2D, h:Int, w:Int, l:Int) = {
    g.setColor(BACKCOLOR)
    g.fillOval(w, h, l, l)
    g.setColor(Color.BLACK)
    g.drawOval(w, h, l, l)
  }
  def drawOutConn(g:Graphics2D, offset:Int, gap:Int) = {
    for (r <- 0 to 2) {
      var end = r * gap
      val r_off = offset + end
      end *= 2
      end += gap
      g.drawRect(r_off, r_off,this.size.height-end,this.size.height-end)
    }
  }
  def drawCross(g:Graphics2D, height:Int, offset:Int) = {
    g.drawLine(offset/2, height/2, height/2 - offset, height/2)
    g.drawLine(height/2, offset/2, height/2 , height/2 - offset)
    g.drawLine(height/2 + offset, height/2, height - offset/2, height/2)
    g.drawLine(height/2, height/2 + offset, height/2, height- offset/2)
  }
  override def paintComponent(g: Graphics2D): Unit = {
    g.setRenderingHint(java.awt.RenderingHints.KEY_ANTIALIASING,
      java.awt.RenderingHints.VALUE_ANTIALIAS_ON)
    g.clearRect(0,0,size.width,size.height)
    g.setColor(BACKCOLOR)
    g.fillRect(0,0,size.width,size.height)

    val gap = size.height/7
    val offset = gap/8
    val length = gap/4*3

    g.setColor(Color.RED)
    drawGrid(g, gap, 7)
    g.setColor(Color.BLACK)
    g.setStroke(new BasicStroke(4F))
    drawOutConn(g, gap/2, gap)
    drawCross(g, size.height, gap)
    drawCircleGrid(g, offset, length, gap)
  }

  def redraw() = repaint()
}
