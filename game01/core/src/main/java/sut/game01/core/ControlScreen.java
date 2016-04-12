package sut.game01.core;

import playn.core.Image;
import playn.core.ImageLayer;
import playn.core.Mouse;
import tripleplay.game.Screen;
import tripleplay.game.ScreenStack;

import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;

public class ControlScreen extends Screen{

    private final ScreenStack ss;
    private final ImageLayer bg;
    private final ImageLayer backButton;

    public ControlScreen(final ScreenStack ss) {
        this.ss = ss;

        Image bgImage = assets().getImage("images/control.jpg");
        this.bg = graphics().createImageLayer(bgImage);

        Image backImage = assets().getImage("images/back.png");
        this.backButton = graphics().createImageLayer(backImage);
        backButton.setTranslation(10, 10);

        backButton.addListener(new Mouse.LayerAdapter() {
            @Override
            public void onMouseUp(Mouse.ButtonEvent event) {
                ss.remove(ss.top()); // pop screen
                System.out.printf("Back to Main Menu.\n");
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
