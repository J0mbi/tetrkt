package dev.jombi.tetris

import org.lwjgl.opengl.GL11

object Drawer {
    fun drawOutLine(x: Float, y: Float, width: Float, height: Float, color: Int) {
        GL11.glPushMatrix()
        GL11.glLineWidth(2.0f)
        GL11.glBegin(GL11.GL_LINE_LOOP)

        val alpha = (color shr 24 and 255).toFloat() / 255.0f
        val red = (color shr 16 and 255).toFloat() / 255.0f
        val green = (color shr 8 and 255).toFloat() / 255.0f
        val blue = (color and 255).toFloat() / 255.0f

        GL11.glColor4f(red, green, blue, alpha)
        GL11.glVertex2f(x, y)
        GL11.glVertex2f(x + width, y)
        GL11.glVertex2f(x + width, y + height)
        GL11.glVertex2f(x, y + height)
        GL11.glEnd()
        GL11.glLineWidth(1.0f)
        GL11.glPopMatrix()
    }

    fun drawLine(x: Float, y: Float, x2: Float, y2: Float, color: Int) {
        GL11.glPushMatrix()
        GL11.glLineWidth(2.0f)
        GL11.glBegin(GL11.GL_LINES)
        val alpha = (color shr 24 and 255).toFloat() / 255.0f
        val red = (color shr 16 and 255).toFloat() / 255.0f
        val green = (color shr 8 and 255).toFloat() / 255.0f
        val blue = (color and 255).toFloat() / 255.0f
        GL11.glColor4f(red, green, blue, alpha)
        GL11.glVertex2f(x, y)
        GL11.glVertex2f(x2, y2)
        GL11.glEnd()
        GL11.glLineWidth(1.0f)
        GL11.glPopMatrix()
    }

    fun drawRect(xx: Number, yy: Number, width1: Number, height1: Number, color: Int) {
        GL11.glPushMatrix()
        GL11.glLineWidth(2.0f)
        GL11.glBegin(GL11.GL_TRIANGLE_FAN)
        val x = xx.toFloat()
        val y = yy.toFloat()
        val width = width1.toFloat()
        val height = height1.toFloat()

        val (red, green, blue, alpha) = fetchColor(color)

        GL11.glColor4f(red, green, blue, alpha)
        GL11.glVertex2f(x, y)
        GL11.glVertex2f(x + width, y)
        GL11.glVertex2f(x + width, y + height)
        GL11.glVertex2f(x, y + height)
        GL11.glEnd()
        GL11.glLineWidth(1.0f)
        GL11.glPopMatrix()
    }

    fun fetchColor(color: Int): FloatArray {
        val f3 = (color shr 24 and 255).toFloat() / 255.0f
        val f = (color shr 16 and 255).toFloat() / 255.0f
        val f1 = (color shr 8 and 255).toFloat() / 255.0f
        val f2 = (color and 255).toFloat() / 255.0f
        return floatArrayOf(f, f1, f2, f3)
    }
}