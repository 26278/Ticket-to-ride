package ttr.Controllers;

import ttr.Model.VolumeModel;

public class VolumeController {
    private VolumeModel vm = new VolumeModel();

    public void setMusicVolume(float volume) {
        vm.setMusicVolume(volume);
    }

    public void setSfxVolume(float volume) {
        vm.setMusicVolume(volume);
    }
}
