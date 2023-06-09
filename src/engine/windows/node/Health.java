package engine.windows.node;

import engine.windows.common.Position;

import java.util.ArrayList;
import java.util.List;

public class Health{
    private List<GameObject> listLifePoint;
    public Health(int lifePoint) {
        this.listLifePoint = new ArrayList<>();
        Heart heartPrototype = Heart.prototype();
        for (int i = 0; i < lifePoint; i++){
            this.listLifePoint.add(new Heart(new Position(i * heartPrototype.getWidth() + 50, 50)));
        }
    }
    public void decreaseLifePoint(){
        listLifePoint.get(listLifePoint.size() - 1).destroyGameObject();
        listLifePoint.remove(listLifePoint.size() - 1);
    }

    public List<GameObject> getListLifePoint() {
        return listLifePoint;
    }
}
