package com.github.translocathor.portalsoundboard.loader

import com.github.translocathor.R
import com.github.translocathor.portalsoundboard.model.Category
import com.github.translocathor.portalsoundboard.model.Sound
import java.util.ArrayList

/**
 * Provides a list of categories that each contains a set of sounds.
 */
class SoundProviderTest : ICategoriesLoader {
    override fun loadCategories(): List<Category> {
        val categories = ArrayList<Category>()

        categories.add(
            Category.createFrom(
                "Turrets",
                Sound.createFrom(R.raw.turret_turret_fire_4x_01, "[Geschützturm Feuer]"),
                Sound.createFrom(R.raw.turret_turret_fire_4x_02, "[Geschützturm Feuer]"),
                Sound.createFrom(R.raw.turret_turret_fire_4x_03, "[Geschützturm Feuer]"),
                Sound.createFrom(R.raw.turret_turretlaunched01_de, "Huiii."),
                Sound.createFrom(R.raw.turret_turretlaunched02_de, "Huiiiiiii."),
                Sound.createFrom(R.raw.turret_turretlaunched03_de, "Ich habe Höhenangst."),
                Sound.createFrom(R.raw.turret_turretlaunched04_de, "Neinnnn."),
                Sound.createFrom(R.raw.turret_turretlaunched05_de, "Bis bald."),
                Sound.createFrom(R.raw.turret_turretlaunched06_de, "Ich hab Angst."),
                Sound.createFrom(R.raw.turret_turretlaunched07_de, "Ich hab Angst."),
                Sound.createFrom(R.raw.turret_turretlaunched08_de, "Hura."),
                Sound.createFrom(R.raw.turret_turretlaunched09_de, "Süße Freiheit."),
                Sound.createFrom(R.raw.turret_turretlaunched10_de, "Ich fliege."),
                Sound.createFrom(R.raw.turret_turretlaunched11_de, "Machs gut."),
                Sound.createFrom(R.raw.turret_turretlightbridgeblock01_de, "Komm näher."),
                Sound.createFrom(R.raw.turret_turretlightbridgeblock02_de, "Merkwürdig."),
                Sound.createFrom(R.raw.turret_turretlightbridgeblock03_de, "Was machst du?"),
                Sound.createFrom(R.raw.turret_turretlightbridgeblock04_de, "Fehler."),
                Sound.createFrom(R.raw.turret_turretshotbylaser01_de, "Au."),
                Sound.createFrom(R.raw.turret_turretshotbylaser02_de, "Auu."),
                Sound.createFrom(R.raw.turret_turretshotbylaser03_de, "Auuuu."),
                Sound.createFrom(R.raw.turret_turretshotbylaser04_de, "Es brennt."),
                Sound.createFrom(R.raw.turret_turretshotbylaser05_de, "Ich brenne."),
                Sound.createFrom(R.raw.turret_turretshotbylaser06_de, "Au, ich brenne."),
                Sound.createFrom(R.raw.turret_turretshotbylaser07_de, "Hör auf."),
                Sound.createFrom(R.raw.turret_turretshotbylaser08_de, "Schon verstanden."),
                Sound.createFrom(R.raw.turret_turretshotbylaser09_de, "Ok, du gewinnst."),
                Sound.createFrom(R.raw.turret_turretshotbylaser10_de, "Das ist nicht gut."),
                Sound.createFrom(R.raw.turret_turretsquashed01_de, "Ooohhh."),
                Sound.createFrom(R.raw.turret_turretsquashed02_de, "aahhh."),
                Sound.createFrom(R.raw.turret_turretsquashed03_de, "Krieg...keine Luft."),
                Sound.createFrom(R.raw.turret_turretsquashed04_de, "Verzeihung du zerquetscht mich."),
                Sound.createFrom(R.raw.turret_turretsquashed05_de, "Äm, hallo."),
                Sound.createFrom(R.raw.turret_turretsquashed06_de, "Hilfe, ich werde zerquetscht!"),
                Sound.createFrom(R.raw.turret_turretwitnessdeath01_de, "Guter Schuss."),
                Sound.createFrom(R.raw.turret_turretwitnessdeath02_de, "Gut gemacht."),
                Sound.createFrom(R.raw.turret_turretwitnessdeath03_de, "Verstärkung."),
                Sound.createFrom(R.raw.turret_turretwitnessdeath04_de, "Du weißt wie man zielt."),
                Sound.createFrom(R.raw.turret_turretwitnessdeath05_de, "Ich hab sie nie gemocht."),
                Sound.createFrom(R.raw.turret_turretwitnessdeath06_de, "Sowas kommt vor."),
                Sound.createFrom(R.raw.turret_turretwitnessdeath07_de, "Das war nicht deine Schult."),
                Sound.createFrom(R.raw.turret_turretwitnessdeath08_de, "Sie hat dich provoziert."),
                Sound.createFrom(R.raw.turret_turretwitnessdeath09_de, "Oh Gott."),
                Sound.createFrom(R.raw.turret_turretwitnessdeath10_de, "Oh je."),
                Sound.createFrom(R.raw.turret_turretwitnessdeath11_de, "Das war meine Schuld."),
                Sound.createFrom(R.raw.turret_turretwitnessdeath12_de, "Sie hat es verdient."),
                Sound.createFrom(R.raw.turret_turretwitnessdeath13_de, "Ich bin Zeuge. Es war ein Unfall."),
                Sound.createFrom(R.raw.turret_turretwitnessdeath14_de, "Ihr geht es bestimmt gut."),
                Sound.createFrom(R.raw.turret_turretwitnessdeath15_de, "Vermerkt."),
                Sound.createFrom(R.raw.turret_sp_sabotage_factory_template01_de, "Hallo?"),
                Sound.createFrom(R.raw.turret_sp_sabotage_factory_good_pass01_de, "Hallo."),
                Sound.createFrom(R.raw.turret_sp_sabotage_factory_good_prerange01_de, "Ziel anvisiert."),
                Sound.createFrom(R.raw.turret_sp_sabotage_factory_good_fail01_de, "Warumm?"),
                Sound.createFrom(R.raw.turret_sp_sabotage_factory_good_fail02_de, "Ich habe doch alles gemaaacht."),
                Sound.createFrom(R.raw.turret_sp_sabotage_factory_good_fail03_de, "Ich versteeehe nicht."),
                Sound.createFrom(R.raw.turret_sp_sabotage_factory_good_fail04_de, "Alles okeey."),
                Sound.createFrom(R.raw.turret_sp_sabotage_factory_good_fail05_de, "Ahhhh."),
                Sound.createFrom(R.raw.turret_sp_sabotage_factory_good_fail06_de, "Huiii, oh nein."),
                Sound.createFrom(R.raw.turret_sp_sabotage_factory_good_fail07_de, "Warum?"),
                Sound.createFrom(R.raw.turret_active, "[Aktivierungs Sound]"),
                Sound.createFrom(R.raw.turret_alarm, "[Alarm Sound]"),
                Sound.createFrom(R.raw.turret_alert, "[Warnungs Sound]"),
                Sound.createFrom(R.raw.turret_deploy, "[Ausfahren Sound]"),
                Sound.createFrom(R.raw.turret_die, "[Todes Sound]"),
                Sound.createFrom(R.raw.turret_ping, "[Ping Sound]"),
                Sound.createFrom(R.raw.turret_retract, "[Einfahren sound]"),
                Sound.createFrom(R.raw.turret_turret_active_1_de, "Hi."),
                Sound.createFrom(R.raw.turret_turret_active_2_de, "Ziel erfasst."),
                Sound.createFrom(R.raw.turret_turret_active_3_de, "Produktausgabe."),
                Sound.createFrom(R.raw.turret_turret_active_4_de, "Feuer."),
                Sound.createFrom(R.raw.turret_turret_active_5_de, "Hallo, Freund."),
                Sound.createFrom(R.raw.turret_turret_active_6_de, "Hab dich."),
                Sound.createFrom(R.raw.turret_turret_active_7_de, "Da bist du."),
                Sound.createFrom(R.raw.turret_turret_active_8_de, "Ich seh dich."),
                Sound.createFrom(R.raw.turret_turret_autosearch_1_de, "Hallooo."),
                Sound.createFrom(R.raw.turret_turret_autosearch_2_de, "Suche."),
                Sound.createFrom(R.raw.turret_turret_autosearch_3_de, "Sondiere."),
                Sound.createFrom(R.raw.turret_turret_autosearch_4_de, "Späh Modus aktiviert."),
                Sound.createFrom(R.raw.turret_turret_autosearch_5_de, "Ist dort jemand?"),
                Sound.createFrom(R.raw.turret_turret_autosearch_6_de, "Könnten sie bitte her kommen?"),
                Sound.createFrom(R.raw.turret_turret_collide_1_de, "Platz da."),
                Sound.createFrom(R.raw.turret_turret_collide_2_de, "Verzeihung."),
                Sound.createFrom(R.raw.turret_turret_collide_3_de, "'tschuldigung."),
                Sound.createFrom(R.raw.turret_turret_collide_4_de, "Hopla."),
                Sound.createFrom(R.raw.turret_turret_collide_5_de, "Ohh."),
                Sound.createFrom(R.raw.turret_turret_deploy_1_de, "Hallo."),
                Sound.createFrom(R.raw.turret_turret_deploy_2_de, "Fahre hoch."),
                Sound.createFrom(R.raw.turret_turret_deploy_3_de, "Ausgabe wird vorbereitet."),
                Sound.createFrom(R.raw.turret_turret_deploy_4_de, "Aktiviert."),
                Sound.createFrom(R.raw.turret_turret_deploy_5_de, "Da bist du."),
                Sound.createFrom(R.raw.turret_turret_deploy_6_de, "Wer da?"),
                Sound.createFrom(R.raw.turret_turret_disabled_1_de, "Ahaha."),
                Sound.createFrom(R.raw.turret_turret_disabled_2_de, "Kritischer Fehler."),
                Sound.createFrom(R.raw.turret_turret_disabled_3_de, "Leider, geschlossen."),
                Sound.createFrom(R.raw.turret_turret_disabled_4_de, "Fahre, runter."),
                Sound.createFrom(R.raw.turret_turret_disabled_5_de, "Ich bin dir nicht böse."),
                Sound.createFrom(R.raw.turret_turret_disabled_6_de, "Ich hasse dich nicht."),
                Sound.createFrom(R.raw.turret_turret_disabled_7_de, "Wisooo?"),
                Sound.createFrom(R.raw.turret_turret_disabled_8_de, "Ich verzeihe dir."),
                Sound.createFrom(R.raw.turret_turret_pickup_1_de, "He."),
                Sound.createFrom(R.raw.turret_turret_pickup_2_de, "Hey hey hey."),
                Sound.createFrom(R.raw.turret_turret_pickup_3_de, "Ich will runter."),
                Sound.createFrom(R.raw.turret_turret_pickup_4_de, "Heeeeee."),
                Sound.createFrom(R.raw.turret_turret_pickup_5_de, "Das ist unzulässig."),
                Sound.createFrom(R.raw.turret_turret_pickup_6_de, "Was soll das?"),
                Sound.createFrom(R.raw.turret_turret_pickup_7_de, "Hey."),
                Sound.createFrom(R.raw.turret_turret_pickup_8_de, "Bitte lass mich runter."),
                Sound.createFrom(R.raw.turret_turret_pickup_9_de, "Nicht."),
                Sound.createFrom(R.raw.turret_turret_pickup_10_de, "Oh oh."),
                Sound.createFrom(R.raw.turret_turret_retire_1_de, "Und tschüss."),
                Sound.createFrom(R.raw.turret_turret_retire_2_de, "Schlafmodus aktivert."),
                Sound.createFrom(R.raw.turret_turret_retire_3_de, "Danke für das Interesse."),
                Sound.createFrom(R.raw.turret_turret_retire_4_de, "Tiefschlaf."),
                Sound.createFrom(R.raw.turret_turret_retire_5_de, "Gut Nacht."),
                Sound.createFrom(R.raw.turret_turret_retire_6_de, "Ruhe."),
                Sound.createFrom(R.raw.turret_turret_retire_7_de, "Schläfchen."),
                Sound.createFrom(R.raw.turret_turret_search_1_de, "Noch jemand da?"),
                Sound.createFrom(R.raw.turret_turret_search_2_de, "Ziel verloren."),
                Sound.createFrom(R.raw.turret_turret_search_3_de, "Kann ich dir helfen?"),
                Sound.createFrom(R.raw.turret_turret_search_4_de, "Suche."),
                Sound.createFrom(R.raw.turret_turret_fizzler_1_de, "Aiaiaiaiaiai."),
                Sound.createFrom(R.raw.turret_turret_shotat_1_de, "He, ich bin's!"),
                Sound.createFrom(R.raw.turret_turret_shotat_2_de, "Schieß nicht!"),
                Sound.createFrom(R.raw.turret_turret_shotat_3_de, "Nicht schießen!"),
                Sound.createFrom(R.raw.turret_turret_tipped_1_de, "Aah."),
                Sound.createFrom(R.raw.turret_turret_tipped_2_de, "Selbsttestfehler."),
                Sound.createFrom(R.raw.turret_turret_tipped_3_de, "Schwerer Fehler."),
                Sound.createFrom(R.raw.turret_turret_tipped_4_de, "Fehlfunktion."),
                Sound.createFrom(R.raw.turret_turret_tipped_5_de, "Aaaah."),
                Sound.createFrom(R.raw.turret_turret_tipped_6_de, "Auauauauauauau."),
                Sound.createFrom(R.raw.turret_turret_protect_humans01_de, "Was machst du?")
            )
        )

        return categories
    }
}