package sut.game01.core;

import playn.core.*;
import sut.game01.core.character.Zealot;
import tripleplay.game.Screen;
import tripleplay.game.ScreenStack;

import static playn.core.PlayN.assets;
import static playn.core.PlayN.graphics;
import playn.core.Keyboard;
import static playn.core.PlayN.*;

public class TestScreen extends Screen{
      private final ScreenStack ss;
   //   private HomeScreen homeScreen;
   // private final ScreenStack ss;
    //private ImageLayer bg;
//    private final ImageLayer backButton;
      private Zealot z ;

    public TestScreen(ScreenStack ss) {
        this.ss = ss;
      //  this.homeScreen = new HomeScreen(ss);

     /*   this.ss = ss;

        Image bgImage = assets().getImage("images/img.png");
        this.bg = graphics().createImageLayer(bgImage);

      /*  Image backImage = assets().getImage("images/back.png");
        this.backButton = graphics().createImageLayer(backImage);
        backButton.setTranslation(10, 10);

        backButton.addListener(new Mouse.LayerAdapter() {
            @Override
            public void onMouseUp(Mouse.ButtonEvent event) {
                ss.remove(ss.top()); // pop screen
                System.out.printf("Back to MainMenu.\n");
            }
        });  */
    }
    @Override
    public void wasShown() {
        super.wasShown();


        Image bgImage = assets().getImage("images/bbbb.jpg");
        ImageLayer bg = graphics().createImageLayer(bgImage);
        this.layer.add(bg);
      //  this.layer.add(backButton);

        z = new Zealot(300f, 340f);
        this.layer.add(z.layer());

        PlayN.keyboard().setListener(new Keyboard.Adapter(){

            @Override
            public void onKeyUp (Keyboard.Event event){

                if (event.key() == Key.SPACE){
                    switch (z.state){
                        case IDLE: z.state = Zealot.State.WALK; break;
                        case WALK: z.state = Zealot.State.ATTK; break;
                        case ATTK: z.state = Zealot.State.IDLE; break;
                    }
                }
                if (event.key() == Key.ENTER){
                    ss.remove(ss.top());
                }
            }
        });

    }

    @Override
    public void update(int delta){
        super.update(delta);
        z.update(delta);
    }

}
