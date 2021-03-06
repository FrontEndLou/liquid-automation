package org.liquidbot.bot.ui;

import org.liquidbot.bot.Configuration;
import org.liquidbot.bot.Constants;
import org.liquidbot.bot.client.RSLoader;
import org.liquidbot.bot.utils.Logger;
import org.liquidbot.bot.utils.Utilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Created by Kenneth on 7/29/2014.
 */
public class BotFrame extends JFrame implements WindowListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 5752868874839930988L;

	private final Logger log = new Logger(getClass());

    private final RSLoader loader;
    private final BotButtonPanel buttonPanel;
    private Configuration configuration = Configuration.getInstance();

    public BotFrame() {
        super(Constants.CLIENT_TITLE + " - v" + Constants.CLIENT_VERSION);

        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));

        this.buttonPanel = new BotButtonPanel();
        this.getContentPane().add(buttonPanel, BorderLayout.NORTH);;
        
        this.loader = new RSLoader(configuration);
        this.getContentPane().add(loader);

        final Image iconImage = Utilities.getLocalImage("/resources/liquidicon.png");

        this.addWindowListener(this);
        this.setLocationRelativeTo(getParent());
        this.setIconImage(iconImage);
        this.pack();
        this.setLocationRelativeTo(getOwner());
    }


    public RSLoader loader() {
        return loader;
    }

    @Override
    public void windowOpened(WindowEvent e) {

    }

    @Override
    public void windowClosing(WindowEvent e) {

    }

    @Override
    public void windowClosed(WindowEvent e) {

    }

    @Override
    public void windowIconified(WindowEvent e) {
        log.info("Lost focus, locking canvas.");
        configuration.drawCanvas(false);
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        log.info("Gained focus, unlocking canvas.");
        configuration.drawCanvas(true);
    }

    @Override
    public void windowActivated(WindowEvent e) {

    }

    @Override
    public void windowDeactivated(WindowEvent e) {

    }
}
