package usantatecla.mastermind.controllers;

import usantatecla.mastermind.models.Game;
import usantatecla.mastermind.models.State;

public class PlayController extends Controller implements InteractorController {

    private ProposalController proposalController;

    PlayController(Game game, State state) {
        super(game, state);
        this.proposalController = new ProposalController(game, state);
    }

    @Override
    public void control() {

    }

}
