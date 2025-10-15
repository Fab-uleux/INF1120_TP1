/*
Prenom nom: Fabien Turgeon
Matricule: TURF01079504
TP1 INF1120 groupe 40
date:14/10/2025
*/

public class MainClass {
    public static void main(String[] args){
        String forfait = "";
        String typeForfait = "";
        String catPersonnes = "";

        int typeFamille = 0;
        String typeGroupe = "";

        int nbCours = 0;
        int nbPersonnes = 0;
        int nbAdulte = 0;
        int nbEnfant = 0;
        int nbAine = 0;
        int age = 0;

        final int coutAnnuel = 750;
        final int coutMensuel = 70;

        double prixInitial = 0;
        double prixHorsTaxe = 0;
        double prixFinal = 0;
        double rabaisAppliquer = 0;

        final double prixTPS = 0.05;
        final double prixTVQ = 0.09975;

        final double rabaisAine = 0.05;
        final double rabaisEnfant = 0.10;
        final double rabaisFamilleDeuxEnfant = 0.6;
        final double rabaisFamilleTroisEnfant = 0.7;
        final double rabaisFamilleQuatreEnfant = 0.8;
        final double rabaisGroupeAine = 0.12;
        final double rabaisGroupeScolaire = 0.15;

        boolean choixForfait = false;
        boolean activite = false;
        boolean annuel = false;
        boolean mensuel = false;

        boolean validation1 = false;
        boolean validation2 = false;
        boolean validation3 = false;
        boolean validation4 = false;
        boolean validation5 = false;
        boolean validation6 = false;


        final String MENU1 = ("******************************************\n" +
                "* Bienvenue au complexe Sportif UQASPORT *\n" +
                "*\n" +
                "* Catégorie des abonnements : *\n" +
                "* ----------------------------\n" +
                "*\n" +
                "* F Forfait (Nombre d'activités illimité) *\n" +
                "* A Activités (Nombre limité) *\n" +
                "******************************************\n" +
                "Choisissez le type d'abonnement :");

        final String MENUFORFAIT = ("******************************************\n" +
                "* Bienvenue au complexe Sportif UQASPORT *\n" +
                "*\n" +
                "* Catégorie de forfait : *\n" +
                "* ----------------------------\n" +
                "*\n" +
                "* A Annuel 750$ *\n" +
                "* M Mensuel 70$ *\n" +
                "******************************************\n" +
                "Choisissez le type de forfait :");

        final String MENUCAT = ("************************************************\n" +
                "* Bienvenue au complexe Sportif UQASPORT *\n" +
                "*\n" +
                "* Catégorie de personnes : *\n" +
                "* ---------------------------- *\n" +
                "* S ou s Personne seule *\n" +
                "* G ou g Groupe *\n" +
                "* F ou f Famille *\n" +
                "************************************************\n" +
                "Entrez la catégorie :");

        final String MENUENFANTAINE = ("*****************************\n" +
                "* Type de groupe : *\n" +
                "* ------------------- *\n" +
                "* A ou a pour aine *\n" +
                "* E ou e pour enfant *\n" +
                "*****************************\n" +
                "- Entrez le type :\n");

        final String MENUFAMILLE = ("***************************************\n" +
                "* Type de famille : *\n" +
                "* ------------------- *\n" +
                "* 1. Deux adultes et deux enfants *\n" +
                "* 2. Deux adultes et trois enfants *\n" +
                "* 3. Deux adultes et quatre enfants *\n" +
                "* 4. Deux adultes et plus de quatre enfants *\n" +
                "***************************************\n" +
                "-Entrez votre choix : 1, 2, 3 ou 4 :");



        while(!validation1){
            System.out.println(MENU1);
            forfait=Clavier.lireString();
            switch(forfait){
                case "a","A":
//                    choixForfait = false;
                    activite = true;
                    System.out.println("Vous avez choisi le format activité");
                    validation1 = true;
                    validation2 = true;
                    break;
                case "f","F":
//                    activite = false;
                    choixForfait = true;
                    System.out.println("Vous avez choisi un format forfait");
                    validation1 = true;
                    validation3 = true;
                    break;
                default:
                    System.out.println("Veuillez sélectionner un forfait valide A ou F");
                    break;
            }
        }

        //Choisir le type de forfait
        while(!validation2) {
            if (choixForfait) {
                System.out.println(MENUFORFAIT);
                typeForfait = Clavier.lireString();
                System.out.println(typeForfait);
            }
            switch (typeForfait) {
                case "a", "A":
                    System.out.println("Annuel");
                    prixInitial = 750;
                    validation2 = true;
                    break;
                case "m", "M":
                    System.out.println("Mensuel");
                    prixInitial = 70;
                    validation2 = true;
                    break;
                default:
                    System.out.println("Veuillez sélectionner un type de forfait valide A ou M");
                    break;
            }
        }

        //Choisir le nombre de cours
        while (!validation3){
            if (activite) {
                System.out.println("Veuillez selectionné le nombre de cour que vous desirez (20$ par cours");
                nbCours = Clavier.lireInt();
                System.out.println(nbCours);
            }
            if(nbCours <= 0){
                System.out.println("Veuillez entrez un nombre supérieur à 0");
            } else {
                System.out.println("Vous avez sélectionné " + nbCours + " cours");
                prixInitial = (nbCours * 20) ;
                System.out.println(prixInitial);
                validation3 = true;
            }
        }

        //Choisir la catégorie de clients
        while(!validation4) {
            System.out.println(MENUCAT);
            catPersonnes = Clavier.lireString();
            switch (catPersonnes){
                case "s","S":
                    System.out.println("Quelle est votre age?");
                    age = Clavier.lireInt();
                    if (age <= 0 || age >= 100){
                        System.out.println("Veuillez entrez un age valide entre 1 et 100");
                    } else if (age <= 12){
                        rabaisAppliquer = rabaisEnfant;
                        System.out.println("Un rabais de 10% seras appliquer au prix finale");
                        validation4=true;
                    } else if (age >= 65 || (age < 18)){
                        rabaisAppliquer = rabaisAine;
                        System.out.println("Un rabais de 5% seras appliquer au prix finale");
                        validation4 = true;
                    }
                    break;
                case "g","G":
                    System.out.println(MENUENFANTAINE);
                    typeGroupe = Clavier.lireString();
                    validation4 = true;
                    break;
                case "f","F":
                    System.out.println(MENUFAMILLE);
                    typeFamille = Clavier.lireInt();
                    validation4 = true;
                    break;
                default:
                    System.out.println("Veuillez sélectionner une catégorie valide S, G ou F");
                    break;
            }
        }

        //Prix finale devra être arrondi
//        double nbr = 12.34567;
//        double nbr2Dec = Math.round(nbr * 100.0) / 100.0;
//        System.out.print(nbr2Dec);

    }
}
