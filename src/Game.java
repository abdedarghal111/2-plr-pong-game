
class Game{

    final Window window;
    final Engine engine;

    public static void main(String[] args){
        Game game = new Game();
        game.start();
    }

    Game(){
        this.window = new Window();
        this.engine = new Engine(window);
    }

    private void start(){
        engine.oneGame(-1);
    }

}