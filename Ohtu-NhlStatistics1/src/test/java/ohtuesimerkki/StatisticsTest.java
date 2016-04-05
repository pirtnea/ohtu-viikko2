package ohtuesimerkki;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class StatisticsTest {

    Statistics stats;
    Reader readerStub = new Reader() {
        
        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    @Before
    public void setUp() {
        stats = new Statistics(readerStub);
    }

    @Test
    public void hakuLoytaaPelaajan() {
        Player pelaaja = stats.search("Kur");
        assertEquals("EDM", pelaaja.getTeam());
    }

    @Test
    public void hakuEiLoydaOlematontaPelaajaa() {
        assertEquals(null, stats.search("Hermanni"));
    }

    @Test
    public void listausJoukkueenPelaajista() {
        List pelaajat = stats.team("EDM");
        assertEquals(pelaajat.toString(), "[Semenko              EDM  4 + 12 = 16, Kurri                EDM 37 + 53 = 90, Gretzky              EDM 35 + 89 = 124]");
    }

    @Test
    public void oikeaMaaraTopScorers() {
        assertEquals(5, stats.topScorers(4).size());
    }
}