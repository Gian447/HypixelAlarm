import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;
import net.hypixel.api.HypixelAPI;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class HypixelAlarm {
    public static void main(String[] args) throws ExecutionException, InterruptedException, JavaLayerException, FileNotFoundException {
        HypixelAPI api = new HypixelAPI(UUID.fromString("hehe"));
        // IN THE VARIABLE BELOW, PUT THE UUID OF THE PERSON WHOSE STATUS YOU WOULD LIKE TO TRACK.
        // YOU CAN GET THE UUID BY GOING TO NAMEMC.COM AND TYPING THEIR NAME IN THE SEARCH BAR.
        String uuid = "hehe";
        Alarm a = new Alarm("speech.mp3");
        int c = 1;
        int lastLogin;
        int lastLogout;
        while (true){
            lastLogout = api.getPlayerByUuid(uuid).get().getPlayer().get("lastLogout").getAsInt();
            lastLogin = api.getPlayerByUuid(uuid).get().getPlayer().get("lastLogin").getAsInt();
            if (lastLogin > lastLogout) break;
            System.out.printf("Query #%d: Still not online...\n", c++);
            Thread.sleep(1000);
        }
        for (int i = 0; i < 3; i++){
            a.play();
        }
    }
}
