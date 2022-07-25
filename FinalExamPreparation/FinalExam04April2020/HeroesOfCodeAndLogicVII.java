package FinalExamPreparation.FinalExam04April2020;

import java.util.*;

public class HeroesOfCodeAndLogicVII {
    static class Hero {
        String heroName;
        int HP;
        int MP;

        public Hero(String heroName, int HP, int MP) {
            this.heroName = heroName;
            this.HP = HP;
            this.MP = MP;
        }

        public String getHeroName() {
            return heroName;
        }

        public void setHeroName(String heroName) {
            this.heroName = heroName;
        }

        public int getHP() {
            return HP;
        }

        public void setHP(int HP) {
            this.HP = HP;
        }

        public int getMP() {
            return MP;
        }

        public void setMP(int MP) {
            this.MP = MP;
        }
    }


    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String, Hero> heroes = new LinkedHashMap<>();
        int heroesCount = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < heroesCount; i++) {
            String[] heroData = scan.nextLine().split("\\s+");
            String heroName = heroData[0];
            int heroHp = Integer.parseInt(heroData[1]);
            int heroMp = Integer.parseInt(heroData[2]);
            Hero currentHero = new Hero(heroName, heroHp, heroMp);
            heroes.put(heroName, currentHero);
        }
        String input = scan.nextLine();
        while (!input.equals("End")) {
            String[] command = input.split(" - ");
            String currentHero = command[1];
            switch (command[0]) {
                case "CastSpell":
                    int mpNeeded = Integer.parseInt(command[2]);
                    String spellName = command[3];
                    if (mpNeeded > heroes.get(currentHero).getMP()) {
                        System.out.printf("%s does not have enough MP to cast %s!%n", currentHero, spellName);
                    } else {
                        int currentMP = heroes.get(currentHero).getMP() - mpNeeded;
                        heroes.get(currentHero).setMP(currentMP);
                        System.out.printf("%s has successfully cast %s and now has %d MP!%n", currentHero, spellName, currentMP);
                    }
                    break;
                case "TakeDamage":
                    int dmgTaken = Integer.parseInt(command[2]);
                    String attacker = command[3];
                    if (dmgTaken >= heroes.get(currentHero).getHP()) {
                        System.out.printf("%s has been killed by %s!%n", currentHero, attacker);
                        heroes.remove(currentHero);
                    } else {
                        int currentHP = heroes.get(currentHero).getHP() - dmgTaken;
                        heroes.get(currentHero).setHP(currentHP);
                        System.out.printf("%s was hit for %d HP by %s and now has %d HP left!%n", currentHero, dmgTaken, attacker, currentHP);
                    }
                    break;
                case "Recharge":
                    int mpToRecharge = Integer.parseInt(command[2]);
                    int currentHeroMp = heroes.get(currentHero).getMP();
                    if (mpToRecharge + currentHeroMp > 200) {
                        System.out.printf("%s recharged for %d MP!%n", currentHero, 200 - currentHeroMp);
                        currentHeroMp = 200;
                        heroes.get(currentHero).setMP(currentHeroMp);
                    } else {
                        System.out.printf("%s recharged for %d MP!%n", currentHero, mpToRecharge);
                        heroes.get(currentHero).setMP(currentHeroMp + mpToRecharge);
                    }
                    break;
                case "Heal":
                    int hpToRecharge = Integer.parseInt(command[2]);
                    int currentHeroHp = heroes.get(currentHero).getHP();
                    if (hpToRecharge + currentHeroHp > 100) {
                        System.out.printf("%s healed for %d HP!%n", currentHero, 100 - currentHeroHp);
                        currentHeroHp = 100;
                        heroes.get(currentHero).setHP(currentHeroHp);
                    } else {
                        System.out.printf("%s healed for %d HP!%n", currentHero, hpToRecharge);
                        heroes.get(currentHero).setHP(currentHeroHp + hpToRecharge);
                    }
                    break;
            }
            input = scan.nextLine();
        }
        heroes.values().forEach(hero -> System.out.printf("%s%n  HP: %d%n  MP: %d%n", hero.getHeroName(), hero.getHP(), hero.getMP()));
    }
}
