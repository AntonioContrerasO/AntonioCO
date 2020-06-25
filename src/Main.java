public class Main {
    public static void main(String[] args) {
        Menu menu = new Menu();

        while (menu.juegoMenu.game.ciclo) {
            menu.juegoMenu.game.repaint();
            try {
                Thread.sleep(20);
            } catch (InterruptedException r) {
                r.printStackTrace();
            }
            if (!menu.juegoMenu.game.ciclo) {
                menu.juegoMenu.game.gameOver();
                if (menu.juegoMenu.game.visibleP) {
                    menu.juegoMenu.setVisible(true);
                    menu.juegoMenu.game.setVisible(false);
                    menu.juegoMenu.game.visibleP = false;
                }
            }
        }

//        Game game = new Game();
//        game.setVisible(true);
//        int x=0;
//        while (game.ciclo) {
//            x = game.balls.size() * 3;
//            game.repaint();
//            try {
//                Thread.sleep(30 - x);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            if (!game.ciclo) {
//                game.gameOver();
//
//            }
//        }
//    }

    }
}

