package sut.game01.core.character;

import playn.core.*;
import playn.core.Keyboard;
import playn.core.Layer;
import playn.core.PlayN;
import playn.core.util.Callback;
import sut.game01.core.HomeScreen;
import sut.game01.core.sprite.Sprite;
import sut.game01.core.sprite.SpriteLoader;
import tripleplay.game.ScreenStack;

public class Zealot {

    private Sprite sprite;
    private int spriteIndex = 0;
    private boolean hasLoaded =false;
    private ScreenStack ss;

    public enum State{
        IDLE, WALK, ATTK

    };
    public State state = State.IDLE;

    private int e = 0;
    private int offset = 0;

   public Zealot(final float x ,final float y) {


       sprite = SpriteLoader.getSprite("images/zealot.json");
       sprite.addCallback(new Callback<Sprite>() {
           @Override
           public void onSuccess(Sprite result) {
               sprite.setSprite(spriteIndex);
               sprite.layer().setOrigin(
                       sprite.width() /2f,
                       sprite.height() /2f
               );
               sprite.layer().setTranslation(x, y + 13f);
               hasLoaded = true;
           }

          @Override
           public void onFailure(Throwable cause) {

       }
      });
   }
    public Layer layer(){
        return sprite.layer();
    }

    public void update(int delta){
        if(hasLoaded == false) return;
        e = e + delta;

        if(e > 190){
            switch(state){
                case IDLE: offset = 0;  break;
                case WALK: offset = 4;  break;
                case ATTK: offset = 8;  break;
            }
            spriteIndex = offset + ((spriteIndex + 1)%4);
            sprite.setSprite(spriteIndex);
            e = 0;
        }
    }
}
