package sut.game01.core;

import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.Mouse;
import tripleplay.game.Screen;
import tripleplay.game.ScreenStack;

import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;

public class TestScreen extends Screen{

    private final ScreenStack ss;
    private final ImageLayer bg;
    private final ImageLayer backButton;

    public TestScreen(final ScreenStack ss) {
        this.ss = ss;

        Image bgImage = assets().getImage("images/bg.png");
        this.bg = graphics().createImageLayer(bgImage);

        Image backImage = assets().getImage("images/b.png");
        this.backButton = graphics().createImageLayer(backImage);
        backButton.setTranslation(10, 10);

        backButton.addListener(new Mouse.LayerAdapter() {
            @Override
            public void onMouseUp(Mouse.ButtonEvent event) {
                ss.remove(ss.top()); // pop screen
            }
        });
    }
    @Override
    public void wasShown() {
        super.wasShown();
        this.layer.add(bg);
        this.layer.add(backButton);
    }

}
