package screens.draganddrop;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.util.InputAdapter;

import java.util.ArrayList;

public class DragAndDropManager extends InputAdapter {

    private ArrayList<PartDraggable> draggables;
    private ArrayList<PartDragArea> dragAreas;

    public DragAndDropManager(){
        draggables = new ArrayList<>();
        dragAreas = new ArrayList<>();
    }

    public void init(GameContainer gc){
        gc.getInput().addPrimaryListener(this);
    }

    public void attatch(PartDraggable d){
        draggables.add(d);
    }

    public void attatch(PartDragArea da){
        dragAreas.add(da);
    }

    public void mousePressed(int button, int x, int y) {
        for(PartDraggable d : draggables) {
            if (!d.isClicked() && d.contains(x, y)) {
                d.setClicked(true);
            }
        }
    }

    public void mouseReleased(int button, int x, int y) {
        for(PartDraggable d : draggables) {
            if (d.isClicked()) {
                for(PartDragArea da : dragAreas) {
                    if(d.getRect().intersects(da.getRect())){
                        PartDraggable oldPart = da.getPart();
                        d.getHome().setPart(null); // clean-up the old home
                        if( oldPart != null) {
                            d.getHome().link(oldPart);
                            oldPart.goHome();
                        }
                        da.link(d);
                        d.goHome();
                    }
                }

                d.setClicked(false);
                d.goHome();
            }
        }
    }


    public void mouseDragged(int oldx, int oldy, int newx, int newy) {
        for(PartDraggable d : draggables) {
            if (d.contains(oldx, oldy) && d.isClicked()) {
                d.setX(d.getX() + newx - oldx);
                d.setY(d.getY() + newy - oldy);
            }
        }
    }
}
