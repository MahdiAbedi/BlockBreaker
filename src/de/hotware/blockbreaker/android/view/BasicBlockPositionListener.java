package de.hotware.blockbreaker.android.view;

import org.andengine.entity.modifier.MoveByModifier;

import de.hotware.blockbreaker.model.listeners.IBlockPositionListener;

public class BasicBlockPositionListener implements IBlockPositionListener {

	protected BlockSprite mBlockSprite;

	public BasicBlockPositionListener(BlockSprite pBlockSprite) {
		this.mBlockSprite = pBlockSprite;
	}

	@Override
	public void onPositionChanged(BlockPositionChangedEvent pEvt) {
		int newX = pEvt.getSource().getX();
		int newY = pEvt.getSource().getY();
		int oldX = pEvt.getOldX();
		int oldY = pEvt.getOldY();
		MoveByModifier moveMod = new MoveByModifier(UIConstants.SPRITE_FADE_IN_TIME, 
				(newX-oldX)*(this.mBlockSprite.getWidth()+1),
				(newY-oldY)*(this.mBlockSprite.getHeight()+1));
		this.mBlockSprite.registerEntityModifier(moveMod);
	}
}
