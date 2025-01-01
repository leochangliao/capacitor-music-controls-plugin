import { WebPlugin } from '@capacitor/core';
import { CapacitorMusicControlsInfo, CapacitorMusicControlsPlugin } from ".";
export declare class CapacitorMusicControlsWeb extends WebPlugin implements CapacitorMusicControlsPlugin {
    constructor();
    create(options: CapacitorMusicControlsInfo): Promise<any>;
    destroy(): Promise<any>;
    updateDismissable(dismissable: boolean): void;
    updateElapsed(args: {
        elapsed: number;
        isPlaying: boolean;
    }): void;
    updateIsPlaying(args: {
        elapsed: number;
        isPlaying: boolean;
    }): void;
    updateMetaData(args:{
        track: string;
        artist: string;
        album: string;
        cover: string;
        duration: number;
    }): void;
}
