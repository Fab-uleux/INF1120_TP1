/*
Prenom nom: Fabien Turgeon
Matricule: TURF01079504
TP1 INF1120 groupe 40
date:14/10/2025
*/

//Git hub: https://github.com/Fab-uleux/INF1120_TP1

public class MainClass {
    public static void main(String[] args){
        //String
        String forfait = "";
        String typeForfait = "";
        String catPersonnes = "";

        //int
        int typeFamille = 0;
        int typeGroupe = 0;
        int nbCours = 0;
        int nbPersonnes = 0;
        int nbAdulte = 0;
        int nbEnfant = 0;
        int nbEnfantFamille = 0;
        int nbAine = 0;
        int age = 0;
        int optionPaiement = 0;

        //final int
        final int coutAnnuel = 750;
        final int coutMensuel = 70;

        //double
        double prixInitial = 0.00;
        double prixHorsTaxe = 0.00;
        double prixFinal = 0.00;
        double rabaisAppliquer = 0.00;
        double prixTVQ = 0.00;
        double prixTPS = 0.00;
        double prixPayer = 0.00;

        //final double
        final double tps = 0.05;
        final double tvq = 0.09975;
        final double rabaisAine = 0.05;
        final double rabaisEnfant = 0.10;
        final double rabaisFamilleDeuxEnfant = 0.06;
        final double rabaisFamilleTroisEnfant = 0.07;
        final double rabaisFamilleQuatreEnfant = 0.08;
        final double rabaisGroupeAine = 0.12;
        final double rabaisGroupeScolaire = 0.15;

        //boolean
        boolean choixForfait = false;
        boolean activite = false;
        boolean annuel = false;
        boolean mensuel = false;

        //boolean validation
        boolean validation1 = false;
        boolean validation2 = false;
        boolean validation3 = false;
        boolean validation4 = false;
        boolean validation5 = false;
        boolean validation6 = false;


        //final string MENU
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

        final String MENUCATEGORIE = ("************************************************\n" +
                "* Bienvenue au complexe Sportif UQASPORT *\n" +
                "*\n" +
                "* Catégorie de personnes : *\n" +
                "* ---------------------------- *\n" +
                "* S ou s Personne seule *\n" +
                "* G ou g Groupe *\n" +
                "* F ou f Famille *\n" +
                "************************************************\n" +
                "Entrez la catégorie :");

        final String MENUGROUPE = ("*****************************\n" +
                "* Type de groupe : *\n" +
                "* ------------------- *\n" +
                "* 1 pour aine *\n" +
                "* 2 pour enfant *\n" +
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

        final String MENUPAIEMENT = ("***************************************\n" +
                "* Type de paiements : *\n" +
                "* ------------------- *\n" +
                "* 1. Cash *\n" +
                "* 2. Crédit *\n" +
                "* 3. Une quille pis 2 clopes *\n" +
                "***************************************\n" +
                "-Entrez votre choix : 1, 2 ou 3 :");

        //Sélection du type forfait ou activité
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

        //Choisir le type de forfait annuel ou mensuel
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

        //Choisir le nombre de cours si type activité fut sélectionner
        while (!validation3){
            if (activite) {
                System.out.println("Veuillez sélectionné le nombre de cour que vous désirez (20$ par cours");
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

        //Choisir la catégorie de clients ou groupe et appliqué le rabais associé
        while(!validation4) {
            System.out.println(MENUCATEGORIE);
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
                        nbEnfant = 1;
                        validation4=true;
                    } else if (age >= 65 || (age < 18)){
                        rabaisAppliquer = rabaisAine;
                        System.out.println("Un rabais de 5% seras appliquer au prix finale");
                        nbAine = 1;
                        validation4 = true;
                    }
                    break;
                case "g","G":
                    System.out.println(MENUGROUPE);
                    typeGroupe = Clavier.lireInt();
                    if(typeGroupe == 1){
                        System.out.println("vous avez sélectionner un groupe de type aînés");
                        rabaisAppliquer = rabaisGroupeAine;
                        System.out.println("Un rabais de 12% seras appliquer au prix finale");
                        validation4 = true;
                    } else if(typeGroupe ==2){
                        System.out.println("vous avez sélectionner un groupe de type enfant");
                        rabaisAppliquer = rabaisGroupeScolaire;
                        System.out.println("Un rabais de 15% seras appliquer au prix finale");
                        validation4 = true;
                    } else {
                        System.out.println("Veuillez sélectionner un choix valide, 1 pour groupe d'aînés et 2 pour un groupe scolaire.");
                }
                    break;
                case "f","F":
                    System.out.println(MENUFAMILLE);
                    typeFamille = Clavier.lireInt();
                    if(typeFamille == 1){
                        System.out.println("Vous avez choisi une famille de deux adulte et deux enfants");
                        rabaisAppliquer = rabaisFamilleDeuxEnfant;
                        System.out.println("Un rabais de 6% seras appliquer au prix finale");
                        nbAdulte = 2;
                        nbEnfant = 2;
                        validation4 = true;
                    } else if (typeFamille == 2){
                        System.out.println("Vous avez choisi une famille de deux adulte et trois enfants");
                        rabaisAppliquer = rabaisFamilleTroisEnfant;
                        System.out.println("Un rabais de 7% seras appliquer au prix finale");
                        nbAdulte = 2;
                        nbEnfant = 3;
                        validation4 = true;
                    } else if (typeFamille == 3){
                        System.out.println("Vous avez choisi une famille de deux adulte et quatre enfants");
                        rabaisAppliquer = rabaisFamilleQuatreEnfant;
                        System.out.println("Un rabais de 8% seras appliquer au prix finale");
                        nbAdulte = 2;
                        nbEnfant = 4;
                        validation4 = true;
                    } else if (typeFamille == 4){
                        System.out.println("Vous avez choisi une famille de deux adulte et quatre enfants et plus");
                        rabaisAppliquer = rabaisFamilleQuatreEnfant;
                        System.out.println("Un rabais de 8% seras appliquer au prix finale et un rabais de 10% seras appliquer par enfant additionel");
                        nbAdulte = 2;
                        validation4 = true;
                    } else {
                        System.out.println("Veuillez sélectionner une option valide");
                    }
                    break;
                default:
                    System.out.println("Veuillez sélectionner une catégorie valide S, G ou F");
                    break;
            }

            //Si groupe sélectionner, choix du nombre de personne dans le groupe.
            if (typeGroupe == 1) {
                do {
                    System.out.println("Veuillez sélectionner le nombre d'aînés dans votre groupe (10 minimum):");
                    nbAine = Clavier.lireInt();
                    if (nbAine < 10) {
                        System.out.println("Le groupe doit contenir au moins 10 aînés, réessayez.");
                    }
                } while (nbAine < 10);
                System.out.println("Vous avez sélectionné un groupe de " + nbAine + " aînés.");
                prixInitial = prixInitial * nbAine;
            }else if (typeGroupe == 2) {
                do {
                    System.out.println("Veuillez sélectionner le nombre d'enfant dans votre groupe (10 minimum):");
                    nbEnfant = Clavier.lireInt();
                    if (nbEnfant < 10) {
                        System.out.println("Le groupe doit contenir au moins 10 enfants, réessayez.");
                    }
                } while (nbEnfant < 10);
                System.out.println("Vous avez sélectionné un groupe de " + nbEnfant + " enfants");
                prixInitial = prixInitial * nbEnfant;
            }

            //si famille a plus que 4 enfant, applique un rabais associer et applique la valuer a nbEnfant.
            if (typeFamille == 4){
                System.out.println("Veuillez sélectionner le nombre d'enfant totales dans votre famille:");
                nbEnfantFamille = Clavier.lireInt();
                do {
                    nbEnfant = (nbEnfant - 4);
                }while (nbEnfant > 4);
            }

            // Calculer le prix finale
            prixHorsTaxe = prixInitial * (1 - rabaisAppliquer);
            prixTPS = prixHorsTaxe * tps;
            prixTVQ = prixHorsTaxe * tvq;
            prixFinal = prixHorsTaxe + prixTPS + prixTVQ;
            prixFinal = Math.round(prixFinal * 100.0) / 100.0;

            //Doit être positionner ici dans le code puisque les valeur ne seront pas mis a jours ci declarer au debut du code
            final String MENUFACTURE = ("************************************************\n" +
                    "* Voici la facture détailler: *\n" +
                    "* Prix hors taxe: " + prixHorsTaxe + " $ *\n" +
                    "* TPS: " + prixTPS + " $ *\n" +
                    "* TVQ: " + prixTVQ + " $ *\n" +
                    "* Prix final: " + prixFinal + " $ *\n" +
                    "************************************************\n" +
                    "Veuillez sélectionner une des options de paiements suivant :");

            //Si il n'y as pas de rabais, n'affiche pas le montant sauvé
            if (prixInitial != prixHorsTaxe){
                System.out.println("\n* Vous avez sauvez " + (prixInitial - prixHorsTaxe) + " $ *\n");
            }

            // Afficher la facture en détail
            System.out.println(MENUFACTURE);

            //Choix du type de paiement
            while (!validation5){
                System.out.println(MENUPAIEMENT);
                optionPaiement = Clavier.lireInt();
                switch (optionPaiement){
                    case 1:
                        System.out.println("Cash?!? dans cette économie?\n");
                        System.out.println("Veuillez entrez le montant montant payer");

                        validation5 = true;
                        break;
                    case 2:
                        System.out.println("Veuillez entrez le montant montant payer");
                        validation5 = true;
                        break;
                    case 3:
                        System.out.println("Yeeeaaah booooooi !1!!");
                        validation5 = true;
                        break;
                    default:
                        System.out.println("Veuillez choisir une des option valide");
                }
                System.out.println("Votre paiement à été accepter, une facture vous seras envoyé sous peu.");
            }
        }

    }
}
