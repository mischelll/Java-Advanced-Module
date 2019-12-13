package viceCity.models.guns;

public class Pistol extends BaseGun {
    private static final int BULLETS_PER_BARREL = 10;
    private static final int TOTAL_BULLETS = 100;
    private static final int SHOOT_COUNT_BULLETS = 1;

    public Pistol(String name) {
        super(name, BULLETS_PER_BARREL, TOTAL_BULLETS);
    }

    @Override
    public int fire() {
        if (this.getBulletsPerBarrel() == 0) {
            this.reload();

            if (this.getBulletsPerBarrel() == 0) {
                return 0;
            }
        }

        super.setBulletsPerBarrel(getBulletsPerBarrel() - SHOOT_COUNT_BULLETS);

        return SHOOT_COUNT_BULLETS;
    }

    private void reload() {
        if (this.getTotalBullets() > 0) {
            int rest = this.getTotalBullets() - BULLETS_PER_BARREL;
            this.setTotalBullets(rest);
            this.setBulletsPerBarrel(BULLETS_PER_BARREL);
        }

    }
}
