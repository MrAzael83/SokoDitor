package launcher;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

/**
 * Created by elekhyr on 01/04/16.
 */
public class ComponentSettings {


    private static Font setFont(String name, int size){
        Font f = new Font("Calibri", Font.TRUETYPE_FONT, size);
        try {
            f = Font.createFont(Font.TRUETYPE_FONT, new File("Fonts/"+name+".ttf"));
            f = f.deriveFont(Font.TRUETYPE_FONT, size);

        } catch (FontFormatException | IOException e) {
            e.printStackTrace();
        }
        return f;
    }

    public static void initializeDefaultButton(JButton button){
        button.setFont(ComponentSettings.FONT);
        button.setOpaque(false);
        button.setFocusPainted(false);
        button.setBorderPainted(false);
        button.setContentAreaFilled(false);

        button.setForeground(ComponentSettings.BUTTON_BACKGROUND_COLOR);
        button.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                button.setForeground(ComponentSettings.FOREGROUND_COLOR);
            }

            public void mouseExited(java.awt.event.MouseEvent evt) {
                button.setForeground(ComponentSettings.BUTTON_BACKGROUND_COLOR);
            }
        });
    }

    public static JButton initializeBackButton(JButton button){

        initializeDefaultButton(button);
        if (ComponentSettings.RETURN_IMAGE == null){
            button.setText(ComponentSettings.RETURN_BUTTON_TEXT);
        }
        else {
            ImageIcon icon = new ImageIcon(
                    ComponentSettings.RETURN_IMAGE.getScaledInstance(
                            ComponentSettings.BACK_BUTTON_WIDTH,
                            ComponentSettings.BACK_BUTTON_HEIGHT,
                            Image.SCALE_AREA_AVERAGING
                    )
            );

            button.setPreferredSize(
                    new Dimension(
                            icon.getIconWidth(),
                            icon.getIconHeight()
                    )
            );
            button.setIcon(icon);
        }
        return button;
    }

    private static Image UPLOAD_IMAGE = setImage("MenuSprites/upload.jpg");

    public static JButton initializeUploadButton(JButton button){

        initializeDefaultButton(button);
        if (ComponentSettings.UPLOAD_IMAGE == null){
            button.setText("upload");
        }
        else {
            ImageIcon icon = new ImageIcon(
                    ComponentSettings.UPLOAD_IMAGE.getScaledInstance(
                            30,
                            30,
                            Image.SCALE_AREA_AVERAGING
                    )
            );

            button.setPreferredSize(
                    new Dimension(
                            icon.getIconWidth(),
                            icon.getIconHeight()
                    )
            );
            button.setIcon(icon);
        }
        return button;
    }

    private static Image setImage(String name){
        return new ImageIcon("Sprites/"+name).getImage();
    }

    /*************************************************************************
     *                              GENERAL
     *************************************************************************/

    static final Color BACKGROUND_COLOR         = Color.BLACK;
    static final Color FONT_COLOR               = Color.cyan;
    static final Color BUTTON_BACKGROUND_COLOR  = Color.GRAY;
    static final Font FONT                      = setFont("title", 72);
    static final Image RETURN_IMAGE             = setImage("MenuSprites/arrow.png");
    static final Color FOREGROUND_COLOR         = Color.white;

    /*************************************************************************
     *                              MENU
     *************************************************************************/

    static final String MENU_TITLE          = "Menu";
    static final String MENU_BUTTON_TEXT    = "Menu";
    static final Color MENU_BACKGROUND      = Color.black;

    /*************************************************************************
     *                              PLAYER
     *************************************************************************/

    static final String PLAYER_TITLE        = "Player";
    static final String PLAY_BUTTON_TEXT    = "Jouer";


    /*************************************************************************
     *                              EDITOR
     *************************************************************************/

    static final String EDITOR_TITLE            = "Editor";
    static final String EDITOR_BUTTON_TEXT      = "Editer";
    static final String NEW_MAP_TEXT_BUTTON     = "Nouvelle Carte";
    static final String MODIFY_MAP_TEXT_BUTTON  = "Modifier Carte existante";

    /*************************************************************************
     *                              DOWNLOADER
     *************************************************************************/

    static final String DOWNLOADER_TITLE        = "Downloader";
    static final String DOWNLOADER_BUTTON_TEXT  = "Telecharger des niveaux";
    static final String RETURN_BUTTON_TEXT      = "Retourner en arriere";
    static final String REFRESH_BUTTON_TEXT     = "Trouver des niveaux";
    /*************************************************************************
     *                              SETTINGS
     *************************************************************************/

    static final String SETTINGS_TITLE              = "Settings";
    static final String SETTINGS_RESET              = "Valeurs par defaut";
    static final String SETTINGS_SOUND              = "Options sonores";
    static final String SETTINGS_SOUND_MUTE         = "Desactiver le son";
    static final String SETTINGS_SOUND_UNMUTE       = "Activer le son";
    static final String SETTINGS_TEXTURES           = "Choix Textures";
    static final String SETTINGS_TEXTURES_CAISSE    = "Texture caisse";
    static final String SETTINGS_TEXTURES_CAISSE_OK = "Texture caisse en place";
    static final String SETTINGS_TEXTURES_PERSO     = "Texture personage";
    static final String SETTINGS_TEXTURES_DOCK      = "Texture but";
    static final String SETTINGS_TEXTURES_SOL       = "Texture sol";
    static final String SETTINGS_TEXTURES_WALL      = "Texture mur";
    static final String SETTINGS_USER               = "Compte utilisateur";
    static final String SETTINGS_BUTTON_TEXT        = "Options";

    /*************************************************************************
     *                              LOGIN
     *************************************************************************/

    static final String LOGIN_TITLE             = "Log in";
    static final String LOGIN_BUTTON_TEXT       = "Se connecter";
    static final String USERNAME_LABEL          = "Nom d'utilisateur";
    static final String PASSWORD_LABEL          = "Mot de passe";
    static final String GO_SIGNUP_BUTTON_TEXT   = ">> S'enregitrer";
    static final int    BACK_BUTTON_HEIGHT      = 50;
    static final int    BACK_BUTTON_WIDTH       = 100;

    /*************************************************************************
     *                              SIGNUP
     *************************************************************************/

    static final String SIGNUP_TITLE            = "Sign up";
    static final String SIGNUP_BUTTON_TEXT      = "S'enregistrer";
    static final String[] RECOVERY_QUESTIONS    = {"Le nom de votre premier animal de compagnie",
            "Nom de jeune fille de votre mère",
            "Le nom de votre école primaire",
            "La marque de votre première voiture",
            "Votre film préféré"
    };

    /*************************************************************************
     *                              EXIT
     *************************************************************************/

    static final String EXIT_BUTTON_TEXT = "Quitter Sokoditor";

}
