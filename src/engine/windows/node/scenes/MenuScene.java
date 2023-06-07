package engine.windows.node.scenes;

import engine.windows.GameWindows;
import engine.windows.common.Position;
import engine.windows.node.Background;
import engine.windows.node.component.GameButton;
import engine.windows.node.component.ISimpleClickListener;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

import static engine.windows.node.component.GameButton.prototype;

public class MenuScene extends Scene {
    private Background background;
    private GameButton startButton;

    public MenuScene(GameWindows gameWindows) {
        super(gameWindows);
        try {
            this.background = new Background(ImageIO.read(new File("Resources/home-page.png")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        GameButton gameButtonPrototype = GameButton.prototype("Resources/start-button.png");
        this.startButton = new GameButton(
                new Position(gameWindows.getWidth() / 2 - gameButtonPrototype.getWidth() / 2, gameWindows.getHeight() * 5 / 6),
                new ISimpleClickListener() {
                    @Override
                    public void onClick() {
                        PlayScene playScene = new PlayScene(gameWindows);
                        gameWindows.pushScene(playScene);
                    }
                },
                "Resources/start-button.png");
        this.listGameObject.add(startButton);
        this.getMouseListenerList().add(startButton.getMouseListener());
    }

    @Override
    protected void initScene() {

    }

    public void draw(Graphics g) {
        background.draw(g);
        super.draw(g);
    }
}
