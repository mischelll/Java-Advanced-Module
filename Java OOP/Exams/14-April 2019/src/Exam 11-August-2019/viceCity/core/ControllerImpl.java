package viceCity.core;

import viceCity.common.ConstantMessages;
import viceCity.core.interfaces.Controller;
import viceCity.models.guns.Gun;
import viceCity.models.guns.Pistol;
import viceCity.models.guns.Rifle;
import viceCity.models.neighbourhood.GangNeighbourhood;
import viceCity.models.neighbourhood.Neighbourhood;
import viceCity.models.players.CivilPlayer;
import viceCity.models.players.MainPlayer;
import viceCity.models.players.Player;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ControllerImpl implements Controller {
    private static final int CIVIL_PLAYER_LIFE_POINTS = 50;
    private static final int MAIN_PLAYER_LIFE_POINTS = 100;

    private Player player;
    private Neighbourhood neighbourhood;
    private List<Player> civilPlayers;
    private Deque<Gun> guns;

    public ControllerImpl() {
        this.player = new MainPlayer();
        this.neighbourhood = new GangNeighbourhood();
        this.civilPlayers = new LinkedList<>();
        this.guns = new ArrayDeque<>();

    }

    @Override
    public String addPlayer(String name) {
        Player civilPlayer = new CivilPlayer(name);
        this.civilPlayers.add(civilPlayer);
        return String.format(ConstantMessages.PLAYER_ADDED, civilPlayer.getName());
    }

    @Override
    public String addGun(String type, String name) {
        Gun gun = null;
        if (type.equals("Pistol")) {
            gun = new Pistol(name);
        } else if (type.equals("Rifle")) {
            gun = new Rifle(name);
        }

        if (gun == null) {
            return ConstantMessages.GUN_TYPE_INVALID;
        }

        this.guns.offer(gun);

        return String.format(ConstantMessages.GUN_ADDED, gun.getName(), type);
    }

    @Override
    public String addGunToPlayer(String name) {
        if (guns.isEmpty()) {
            return ConstantMessages.GUN_QUEUE_IS_EMPTY;
        }

        Gun gun = this.guns.poll();
        if (name.equals("Vercetti")) {

            this.player.getGunRepository().add(gun);
            return String.format(ConstantMessages.GUN_ADDED_TO_MAIN_PLAYER, gun.getName(), "Tommy Vercetti");
        } else {
            for (Player civilPlayer : this.civilPlayers) {
                if (civilPlayer.getName().equals(name)) {
                    civilPlayer.getGunRepository().add(gun);
                    return String.format(ConstantMessages.GUN_ADDED_TO_CIVIL_PLAYER, gun.getName(), civilPlayer.getName());
                }
            }
        }


        return ConstantMessages.CIVIL_PLAYER_DOES_NOT_EXIST;
    }

    @Override
    public String fight() {
        this.neighbourhood.action(player, civilPlayers);
        boolean check = true;
        long deadCivilPlayers = civilPlayers
                .stream()
                .filter(e -> e.getLifePoints() == 0)
                .count();

        long aliveCivilPlayers = civilPlayers
                .stream()
                .filter(e -> e.getLifePoints() < 50)
                .count();

        long harmedCivilPlayers = civilPlayers
                .stream()
                .filter(e -> e.getLifePoints() > 0 )
                .count();

        if (this.player.getLifePoints() == MAIN_PLAYER_LIFE_POINTS &&
                aliveCivilPlayers == 0) {
            return ConstantMessages.FIGHT_HOT_HAPPENED;
        } else {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(ConstantMessages.FIGHT_HAPPENED).append(System.lineSeparator());
            stringBuilder
                    .append(String.format(ConstantMessages.MAIN_PLAYER_LIVE_POINTS_MESSAGE, player.getLifePoints()))
                    .append(System.lineSeparator())
                    .append(String.format(ConstantMessages.MAIN_PLAYER_KILLED_CIVIL_PLAYERS_MESSAGE, deadCivilPlayers))
                    .append(System.lineSeparator())
                    .append(String.format(ConstantMessages.CIVIL_PLAYERS_LEFT_MESSAGE, harmedCivilPlayers)).append(System.lineSeparator());
            return stringBuilder.toString().trim();
        }


    }
}
