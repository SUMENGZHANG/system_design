package GamingEngine;

import Entity.Deck;
import Entity.GamingDealer;
import Entity.Player;

import java.util.*;
import java.util.Scanner;

public class StartUp {

    public static final int PLAYER_LOWER = 2;
    public static void main(String[] args) {
        final List<Player> players = new ArrayList<>();
        // 加载游戏信息 - 一个发牌员
        Deck deck = new Deck();
        GamingDealer dealer = new GamingDealer(deck,"sexy_xiao_xue");

        // 录入玩家信息
        Scanner scanner = new Scanner(System.in);
        while(players.size() < PLAYER_LOWER) {
            System.out.println("等待更多玩家中。。。当前在线人数："+players.size());
            String curName = scanner.nextLine();
            Player player = new Player(curName);
            players.add(player);
        }

        while (true){
            dealer.coreDuty(players);
            System.out.println("性感荷官正在洗牌。。。。期待好牌");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("发牌失败");
            }
            for(Player player : players) {
                System.out.println("当前牌桌局面");
                System.out.println(player.toString());
            }
            System.out.println("是否再来：1 再来 0退出");
            int i = scanner.nextInt();
            if(i==0){
                System.out.println("感谢支持。。。");
                break;
            }
        }


    }
}
