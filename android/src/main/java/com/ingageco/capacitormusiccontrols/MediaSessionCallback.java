package com.ingageco.capacitormusiccontrols;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.media.session.MediaSessionCompat;
import android.view.KeyEvent;

import com.getcapacitor.JSObject;


public class MediaSessionCallback extends MediaSessionCompat.Callback {

  private CapacitorMusicControls musicControls;


  public MediaSessionCallback(CapacitorMusicControls musicControls){
    this.musicControls=musicControls;
  }

  @Override
  public void onSeekTo(long pos) {
    super.onSeekTo(pos);

    JSObject ret = new JSObject();
    ret.put("message", "music-controls-seek-to");
    ret.put("position",pos);
    this.musicControls.controlsNotification(ret);

  }
  
  @Override
  public void onPlay() {
    super.onPlay();


    JSObject ret = new JSObject();
    ret.put("message", "music-controls-play");
    this.musicControls.controlsNotification(ret);

  }

  @Override
  public void onPause() {
    super.onPause();

    JSObject ret = new JSObject();
    ret.put("message", "music-controls-pause");
    this.musicControls.controlsNotification(ret);

  }

  @Override
  public void onSkipToNext() {
    super.onSkipToNext();

    JSObject ret = new JSObject();
    ret.put("message", "music-controls-next");
    this.musicControls.controlsNotification(ret);

  }

  @Override
  public void onSkipToPrevious() {
    super.onSkipToPrevious();

    JSObject ret = new JSObject();
    ret.put("message", "music-controls-previous");
    this.musicControls.controlsNotification(ret);

  }

  @Override
  public void onPlayFromMediaId(String mediaId, Bundle extras) {
    super.onPlayFromMediaId(mediaId, extras);
  }

  @Override
  public boolean onMediaButtonEvent(Intent mediaButtonIntent) {
    final KeyEvent event = (KeyEvent) mediaButtonIntent.getExtras().get(Intent.EXTRA_KEY_EVENT);
    JSObject ret = new JSObject();

    if (event == null) {
      return super.onMediaButtonEvent(mediaButtonIntent);
    }

    if (event.getAction() == KeyEvent.ACTION_DOWN) {
      final int keyCode = event.getKeyCode();
      switch (keyCode) {
        case KeyEvent.KEYCODE_MEDIA_PAUSE:

          ret.put("message", "music-controls-pause");
          this.musicControls.controlsNotification(ret);

          break;
        case KeyEvent.KEYCODE_MEDIA_PLAY:

          ret.put("message", "music-controls-play");
          this.musicControls.controlsNotification(ret);

          break;
        case KeyEvent.KEYCODE_MEDIA_PREVIOUS:

          ret.put("message", "music-controls-previous");
          this.musicControls.controlsNotification(ret);

          break;
        case KeyEvent.KEYCODE_MEDIA_NEXT:

          ret.put("message", "music-controls-next");
          this.musicControls.controlsNotification(ret);

          break;
        case KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE:

          ret.put("message", "music-controls-toggle-play-pause");
          this.musicControls.controlsNotification(ret);

          break;
        case KeyEvent.KEYCODE_MEDIA_STOP:

          ret.put("message", "music-controls-stop");
          this.musicControls.controlsNotification(ret);

          break;
        case KeyEvent.KEYCODE_MEDIA_FAST_FORWARD:

          ret.put("message", "music-controls-skip-forward");
          this.musicControls.controlsNotification(ret);

          break;
        case KeyEvent.KEYCODE_MEDIA_REWIND:

          ret.put("message", "music-controls-skip-backward");
          this.musicControls.controlsNotification(ret);

          break;
        default:

          ret.put("message", "music-controls-media-button-unknown-" + keyCode);
          this.musicControls.controlsNotification(ret);

          return super.onMediaButtonEvent(mediaButtonIntent);
      }
    }

    return true;
  }
}
