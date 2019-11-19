package util;

import org.newdawn.slick.SlickException;
import org.newdawn.slick.UnicodeFont;
import org.newdawn.slick.font.effects.ColorEffect;

import java.awt.*;
import java.io.IOException;

public class MyFont {

    public static UnicodeFont createFont(float size) throws SlickException {

        Font newFont = null;
        try {
            newFont = Font.createFont(Font.TRUETYPE_FONT, org.newdawn.slick.util.ResourceLoader.getResourceAsStream("inland.ttf"));
        } catch (FontFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Font javaFont = newFont.deriveFont(size);

        UnicodeFont uniFont = new UnicodeFont(javaFont);
        uniFont.addAsciiGlyphs();

        ColorEffect a = new ColorEffect();
        a.setColor(Color.white);

        uniFont.getEffects().add(a);
        uniFont.addAsciiGlyphs();
        uniFont.loadGlyphs();
        return uniFont;
    }
}
