package sut.game01.core;

import playn.core.*;
import react.UnitSlot;
import tripleplay.game.ScreenStack;
import tripleplay.game.UIScreen;
import tripleplay.ui.*;
import tripleplay.ui.layout.AxisLayout;
import static playn.core.PlayN.*;
import playn.core.Keyboard;

public class HomeScreen extends UIScreen {
    public static final Font TITLE_FONT = graphics().createFont("Helvetica",Font.Style.PLAIN,24);
    private ScreenStack ss;

    private Root root;
    public final TestScreen testScreen;
  //  public final ControlScreen controlScreen;
    private ImageLayer start;
    private ImageLayer setting;
    private ImageLayer control;



    public HomeScreen(ScreenStack ss){
        this.ss = ss;
        this.testScreen = new TestScreen(ss);
     //   this.controlScreen = new ControlScreen(ss);

    }
public ScreenStack getSs(){
 return this.ss;
}
    @Override
    public  void wasShown(){
        super.wasShown();
        root = iface.createRoot(
                AxisLayout.vertical().gap(15),
                SimpleStyles.newSheet(), this.layer);
//--------------------------Background-----------------------------
        root.addStyles(Style.BACKGROUND
                .is(Background.image(assets().getImage("images/maze1.gif"))));
        root.setSize(width(), height());

        keyboard().setListener(new Keyboard.Adapter(){

            @Override
            public void onKeyUp (Keyboard.Event event){
                if (event.key() == Key.ENTER){
                    ss.push(testScreen);
                }
            }
        });
         /*
//---------------------------Start Button--------------------------
        Image startButton = assets().getImage("images/start.png");
        this.start = graphics().createImageLayer(startButton);
        start.setTranslation(245,330);

        start.addListener(new Mouse.LayerAdapter() {
            @Override
            public void onMouseUp(Mouse.ButtonEvent event) {
                System.out.printf("Click Play Game.\n");
                ss.push(testScreen);
            }
        });
        
        this.layer.add(start);  
//--------------------------Setting Button------------------------------
        Image settingButton = assets().getImage("images/setting.png");
        this.setting = graphics().createImageLayer(settingButton);
        setting.setTranslation(400, 336);

        setting.addListener(new Mouse.LayerAdapter() {
            @Override
            public void onMouseUp(Mouse.ButtonEvent event) {
                ss.push(testScreen);
            }
        });
        this.layer.add(setting);   
//-------------------------Control Button------------------------------
        Image controlButton = assets().getImage("images/control.png");
        this.control = graphics().createImageLayer(controlButton);
        control.setTranslation(122, 336);

        control.addListener(new Mouse.LayerAdapter() {
            @Override
            public void onMouseUp(Mouse.ButtonEvent event) {
                System.out.printf("Go to Control.");
                ss.push(controlScreen);
            }
        });
        this.layer.add(control);   */
//------------------------------------------------------------------

    }

}
