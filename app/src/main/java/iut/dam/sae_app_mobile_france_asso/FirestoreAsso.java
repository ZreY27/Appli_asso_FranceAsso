package iut.dam.sae_app_mobile_france_asso;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class FirestoreAsso {
    public void ajouterCategories(){
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        // Liste des associations
        String[][] categories = {
                {"1", "Maladies chroniques"},
                {"2", "Accidents et effets secondaires"},
                {"3", "Handicap et dépendance"},
                {"4", "Santé mentale et bien-être psychique"},
                {"5", "Droits des patients et accès aux soins"},
                {"6", "Soutien aux aidants et proches"},
                {"7", "Prévention et santé publique"}

        };

        // Ajout des catégories dans Firestore
        for (String[] categ : categories) {
            String id = categ[0];
            String name = categ[1];

            Map<String, Object> data = new HashMap<>();
            data.put("name", name);

            db.collection("categories").document(id)
                    .set(data)
                    .addOnSuccessListener(aVoid -> Log.d("Firestore", "Categorir ajoutée avec succès"))
                    .addOnFailureListener(e -> Log.w("Firestore", "Erreur lors de l'ajout de la categorie", e));
        }
    }
    public void ajouterAssociations() {
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        // Liste des associations
        String[][] associations = {
                {"1", "A.M.I","6" ,"Depuis 1936, avec et pour les personnes malades, invalides et/ou en situation de handicap, l’A.M.I. nationale agit au quotidien sans discrimination ni privilège, avec pour ojectifs de : promouvoir le « vivre ensemble » avec nos différences, s’engager dans des actions de représentation et de revendication,\n" +
                        "défendre les personnes malades et les personnes en situation de handicap, soutenir ces personnes dans leur quotidien, contribuer à leur épanouissement par des activités ludiques, culturelles, sportives.","https://ami-handicap.france-assos-sante.org/wp-content/uploads/sites/117/2019/01/customLogo.png", "Association des Malades Invalides et handicapés"},
                {"2", "AAAVAM", "2" ,"L’AAAVAM a été fondée en 1992, suite au nombre de suicides de plus en plus élevés en France, imputables aux benzodiazépines.\n" +
                        "\n" +
                        "Buts de l’association :\n" +
                        "\n" +
                        "PRÉVENIR les Citoyens des dangers de certains médicaments aux effets indésirables et paradoxaux très graves mal indiqués dans les notices d’utilisation ou dans le dictionnaire VIDAL®\n" +
                        "OBLIGER les médecins à avertir du danger de dépendance des drogues légales\n" +
                        "FAIRE INTERDIRE de la prescription courante les tranquillisants et les somnifères, les anti-cholestérols, certains anti-douleurs et autres « produits de santé » trop actifs\n" +
                        "AIDER À FAIRE RÉVISER les procès où ces médicaments ont été responsables de crises de violence ayant entraîné « mort d’homme ».\n" +
                        "FAIRE RÉEXAMINER la nomination des médecins experts judiciaires auprès des Tribunaux.\n" +
                        "FAIRE INDEMNISER de manière équitable et automatique les victimes ou leur famille.\n" +
                        "FAIRE POURSUIVRE par la Justice les responsables sanitaires.\n" +
                        "REPRÉSENTER les utilisateurs, auprès des services de pharmacovigilance, et des C.R.C.I.","https://aaavam.france-assos-sante.org/wp-content/uploads/sites/23/2023/06/logo-300x92.png", "Association Nationale de défense des intérêts des Victimes d'Accidents des Médicaments"},
                {"3", "AAVL","7"  ,"L’Association Addictions Alcool Vie Libre accompagne les personnes à sortir de alcoolisme par des actions de prévention et d’aide avant, pendant, après les soins. Elle réalise notamment des actions :\n" +
                        "\n" +
                        "dans les milieux scolaires : la prévention commence dès le plus jeune âge, à l’école en particulier. Le Mouvement Addictions Alcool Vie Libre, avec le concours de tous les personnels enseignants, organise des séances d’information.\n" +
                        "envers les femmes : les femmes rejoignent les hommes dans la consommation d’alcool. Le Mouvement Addictions Alcool Vie Libre leur porte une attention particulière en leur donnant la possibilité de se retrouver et d’échanger entre buveuses guéries ou en voie de guérison, abstinentes volontaires et sympathisantes.\n" +
                        "dans le milieu du travail : le Mouvement Addictions Alcool Vie Libre organise des stages et des plans de prévention, des conférences débats avec toutes les catégories de personnel et des réflexions communes sur les problèmes posés par l’alcool au travail.\n" +
                        "envers les milieux médicaux-sociaux : Le Mouvement Addictions Alcool Vie Libre est souvent appelé à intervenir dans le cycle de formation des infirmières, assistantes sociales, travailleuses familiales, aides soignantes, médecins … pour faire part de son expérience de l’alcoolisme sur le terrain.\n" +
                        "envers l’opinion publique : par des réunions d’information, organisation de stands, diffusion de journaux et documents spécialisés.\n" +
                        "dans le monde carcéral : le Mouvement Addictions Alcool Vie Libre développe une action importante dans les prisons.","https://www.vielibre.org/wp-content/themes/wp-bootstrap-starter/img/logo.jpg", "Association Addictions Alcool Vie Libre"},
                {"4", "ADEPA", "3" ,"L’ A.D.E.P.A est une association faite pour unir nos forces.\n" +
                        "Nous avons tous des problèmes plus ou moins importants liés à notre handicap.\n" +
                        "Nous devons les mettre en commun pour tenter de trouver des solutions.\n" +
                        "Plus L’ A.D.E.P.A aura d’adhérents, plus nous pourrons être entendus par nos interlocuteurs et plus nous pourrons être présents dans sur tout le territoire français auprès des personnes amputées.\n" +
                        "ADEPA est née à Lyon en 1996. Soucieuse de répondre à une attente légitime, ADEPA développe peu à peu des contacts dans les autres régions.","https://www.adepa.fr/wp-content/uploads/2023/10/Logo-ADEPA-associoation-defense-entraide-personnes-amputees.png", "Association de Défense et d'Entraide des Personnes Amputées"},
                {"5", "ADMD","7"  ,"Depuis 1980, l’Association pour le Droit de Mourir dans la Dignité milite pour que chaque Française et chaque Français puisse choisir les conditions de sa propre fin de vie. Conformément à ses conceptions personnelles de dignité et de liberté.\n" +
                        "\n" +
                        "Dans cette perspective, l’ADMD entend obtenir qu’une loi visant à légaliser l’euthanasie et le suicide assisté et à assurer un accès universel aux soins palliatifs soit votée par le Parlement, comme le réclament 93% des Français interrogés par l’institut de sondage Ifop en avril 2021. Avec le vote de cette loi, les Français bénéficieraient de leur ultime liberté, comme les Néerlandais, les Belges, les Luxembourgeois, les Espagnols, les Suisses et bientôt les Portugais en disposent déjà dans leur propre pays\n" +
                        "(pour ne citer que les pays européens).\n" +
                        "\n" +
                        "Le principal objectif de l’ADMD demeure que chacun puisse, à sa stricte demande, bénéficier d’une mort consentie, sereine et digne ; la dignité étant une convenance envers soi dont chacun est seul juge. Cette demande d’aide à mourir doit être évidemment libre, consciente, réitérée et révocable à tout moment, parce qu’il s’agit d’une liberté dont chacun usera ou n’usera pas. Un droit ne sera jamais une obligation…\n" +
                        "\n" +
                        "L’ADMD, également, met en œuvre un Fichier national des directives anticipées (01 48 00 09 89). Ce document précisé par la loi du 2 février 2016 est numérisé et archivé. Ce document est aujourd’hui le meilleur moyen de garantir son propre parcours de fin de vie et, ainsi, d’éviter les tragédies absurdes. Avec le service ADMD-Ecoute, que vous pouvez joindre au 01 48 00 04 92, soyez accompagné et protégez votre fin de vie.\n" +
                        "\n" +
                        "Vous voulez maîtriser votre fin de vie ? C’est votre droit !","https://www.admd.net/themes/custom/admd/images/logo.png", "Association pour le Droit de Mourir dans la Dignité"},
                {"6", "Advocacy France","4" ,"L’association Advocacy France est une association d’usagers en santé mentale , médico-sociale et sociale.\n" +
                        "\n" +
                        "Ses objectifs :\n" +
                        "\n" +
                        "Promouvoir le concept et les pratiques d’advocacy en France en l’adaptant à la culture et à la situation française.\n" +
                        "Animer un mouvement d’action des usagers de santé mentale (advocacy) en France pour une politique de santé citoyenne.\n" +
                        "Créer des actions d’accès au recours permettant que les opinions des usagers soient prises en compte, leurs demandes justifiées entendues, l’accès à la responsabilité reconnu, la dignité et les droits des usagers en santé mentale respectés, ceci dans les champs médical, juridique et social.\n" +
                        "Aider les patients/usagers à être acteurs sociaux, à prendre la parole, à être entendus et reconnus comme responsables à travers l’élaboration et la réalisation de projets collectifs faisant travailler ensemble usagers, professionnels et bénévoles, en partenariat avec d’autres associations.", "https://imgs.search.brave.com/F69AXs3sFuy6Yc7UGIiIBUyLzZMgJZeY5CbnjUlNc2c/rs:fit:860:0:0:0/g:ce/aHR0cHM6Ly93d3cu/ZmVkZXJhdGlvbnNv/bGlkYXJpdGUub3Jn/L3dwLWNvbnRlbnQv/dXBsb2Fkcy8yMDIw/LzA4LzEtQWR2b2Nh/Y3ktRnJhbmNlLTI0/OXgzMDAucG5n", "Advocacy France"},
                {"7", "AFA", "1" ,"Reconnue d’utilité publique, l’AFA se consacre aux Maladies Inflammatoires Chroniques Intestinales (MICI), maladie de Crohn et recto-colite hémorragique.\n" +
                        "\n" +
                        "L’association s’est donnée plusieurs missions :\n" +
                        "\n" +
                        "guérir en soutenant des programmes de recherche fondamentale et clinique, en proposant des améliorations dans le parcours de soins et en produisant des connaissances sur nos maladies ou sur le « vivre avec » ;\n" +
                        "informer et soutenir les malades et leurs proches via un réseau de professionnels et de bénévoles formés répartis sur 22 régions et nos outils internet ;\n" +
                        "partager son expérience avec les autres malades et leurs proches sur internet ou lors de rencontres locales ;\n" +
                        "représenter tous les malades ainsi que leurs proches, porter leurs voix auprès des décideurs politiques et de santé ;\n" +
                        "former et informer les professionnels de santé sur le quotidien avec la maladie ;\n" +
                        "communiquer sur nos maladies encore beaucoup trop méconnues et tabous ;\n" +
                        "agir en tant qu’acteur de santé publique dans la démocratie sanitaire.","https://www.afa.asso.fr/wp-content/uploads/2019/09/LOGO-AFA.png", "Association François Aupetit"},
                {"8", "AFDE", "2" ,"L’AFDE est née en 2000 de la volonté de briser l’isolement extrême dans lequel était projeté les familles qui apprenaient la naissance d’un enfant atteint de dysplasies ectodermiques (DE). Les dysplasies ectodermiques sont un ensemble de maladies génétiques rares affectant de façon définitive et sévère de nombreux organes issus de l’ectoderme : peau, glandes sudorales, yeux, poumons, dents, cheveux, système digestif, etc. Dans la forme la plus courante, les personnes atteintes ne transpirent pas et craignent donc la chaleur. Elles ont peu ou pas de dents, de forme conique. Enfin, leur peau et leurs yeux sont secs et nécessitent des soins plusieurs fois par jour, elles peuvent avoir des problèmes digestifs, pulmonaires, d’élocution, etc.\n" +
                        "\n" +
                        "L’AFDE a pour but de rompre l’isolement des personnes et des familles atteintes par une dysplasie ectodermique, de les soutenir psychologiquement et matériellement, de réunir toute l’information et de la diffuser, de fédérer les initiatives médicales et la recherche scientifique.","https://afde.net/wp-content/uploads/2022/10/logo-afde.jpg", "Association Française de Dysplasies Ectodermiques"},
                {"9", "AFDOC","2"  ,"L’AFDOC est une association de santé avec la qualification de bienfaisance et d’assistance, agréée par le ministère de la Santé.\n" +
                        "\n" +
                        "Elle a pour but :\n" +
                        "\n" +
                        "De développer et d’entretenir des liens de solidarité et d’amitié entre tous les malades atteints de pathologies cardiaques.\n" +
                        "D’informer et d’aider ces malades dans leur vie quotidienne au niveau personnel, social et professionnel.\n" +
                        "De participer à la prévention et à l’éducation thérapeutique des patients.\n" +
                        "De représenter tous les usagers de la médecine dans les instances hospitalières et de santé publique et de participer aux différentes commissions telles que les CRUQS, les CLIN, les CLAN, les CLUD, etc.\n" +
                        "D’être présent dans les Conseils de surveillance des établissements hospitaliers.\n" +
                        "De venir en aide à des malades atteints de maladies cardiovasculaires.\n" +
                        "De participer à la recherche médicale.\n" +
                        "De participer à la certification des établissements hospitaliers.","https://afdoc.fr/local/cache-vignettes/L400xH120/afdoc-logo-05-38b2c.png?1710244315", "Association Française Des malades et Opérés Cardio-vasculaires"},
                {"10", "AFGS","2"  ,"L’Association Française du Gougerot Sjögren et des syndromes secs (AFGS) a été créée en 1990. C’est une association à but non lucratif, régie par la loi de 1901. Elle est reconnue association d’utilité publique depuis le 20 septembre 2004.\n" +
                        "\n" +
                        "Elle est animée par des malades bénévoles et une collaboratrice salariée. L’Association a pour but de donner des informations concernant ces syndromes, apporter un soutien moral aux malades, permettre aux malades de se rencontrer, aider financièrement la recherche médicale.\n" +
                        "L’AFGS est agréée au niveau national depuis le 11 août 2006 par le Ministère de la Santé pour représenter les usagers dans les instances hospitalières ou de santé publique.","https://www.afgs-syndromes-secs.org/assets/logo/logo_afgs.png", "Association Française du Gougerot sjögren et des syndromes secs"},
                {"11", "AFH","2" , "Fondée en 1955 par des hémophiles et des parents en collaboration avec des médecins spécialistes, l’Association française des hémophiles s’est donnée un rôle d’information et d’entraide. Elle est reconnue d’utilité publique depuis 1968. L’association milite pour une amélioration constante des connaissances et des traitements de l’hémophilie. Pour être plus forte, l’AFH est membre de la Fédération mondiale de l’Hémophilie. Pour être plus proche de ses adhérents, des comités régionaux sont présents dans toute la France.\n" +
                        "\n" +
                        "L’AFH organise des réunions d’information, des stages de formation au traitement à domicile, des séjours sanitaires, des voyages et des camps de vacances pour les enfants et les adolescents, des rencontres entre parents, etc.","https://app.assoconnect.com/services/storage?id=5111433&type=picture&secret=lD13fanUd1Wm20DvBoeXAme1FZtX0wKvwzeKRG0f&timestamp=1733500311&size=small", "Association Française des Hémophiles"},
                {"12", "AFM", "1" ,"Crée en 1958 et reconnue d’utilité publique en 1976, l’AFM-Téléthon est une association de malades et parents de malades qui mène un combat sans relâche contre des maladies génétiques, rares et lourdement invalidantes, les maladies neuromusculaires.\n" +
                        "\n" +
                        "Son objectif : vaincre la maladie. Guidée par l’intérêt des malades et l’urgence de la maladie évolutive, elle mène une stratégie d’intérêt général qui bénéficie à l’ensemble des maladies rares et des personnes en situation de handicap.\n" +
                        "\n" +
                        "L’AFM-Téléthon s’est fixée 3 missions :\n" +
                        "Guérir (recherche et développement de thérapies innovantes), Aider les malades (soins, accompagnement, citoyenneté), Communiquer les savoirs auprès des familles, professionnels et du grand public.\n" +
                        "\n" +
                        "Elle organise, chaque premier week-end de décembre, le Téléthon, un événement national de sensibilisation et de collecte qui mobilise 250 000 bénévoles et 5 millions de Français sur tout le territoire","https://www.afm-telethon.fr/sites/default/files/styles/webp/public/logo/AFM_TELETHON_Q.png.webp?itok=CM1KrGfb", "AFM-Téléthon"},
                {"13", "AFPric","1" , "L’Association française des Polyarthritiques et des rhumatismes inflammatoires chroniques est une association loi 1901, reconnue d’utilité publique, qui mène de nombreuses actions d’information pour permettre à toutes et à tous de mieux comprendre la maladie et de mieux se repérer dans les traitements. Ses objectifs sont d’aider les patients à mieux vivre avec cette maladie chronique, de représenter et de défendre leurs intérêts et de promouvoir la recherche.","https://www.polyarthrite.org/wp-content/uploads/2023/07/logo_poly.png", "Association française des Polyarthritiques et des rhumatismes inflammatoires chroniques"},
                {"14", "AFS","1","L’Association France Spondyloarthrites (AFS) est une association de malades administrée par des malades et leur famille, pour des malades, leur famille et leurs proches partout en France.\n" +
                        "Nombre de personne touchées en France : entre 200 et 300 000.\n" +
                        "\n" +
                        "Délai de diagnostique en moyenne de 3 à 6 ans.\n" +
                        "\n" +
                        "Cette maladie perturbe considérablement la vie sociale et professionnelle des malades.\n" +
                        "La maladie évolue par poussées.\n" +
                        "Nos bénévoles sont toujours disponibles et à l’écoute. « Délégations dans les régions »\n" +
                        "\n" +
                        "Ne restez plus seul. Rejoignez-nous !"  ,"https://www.spondy.fr/wp-content/uploads/2024/11/Logo-AFS-Et-Rics.png", "Association France Spondyloarthrites"},
                {"15", "AFSA","2" ,"L’Association française du syndrome d’Angelman (AFSA) a été créée en 1992 pour venir en aide aux familles touchées par ce syndrome.\n" +
                        "\n" +
                        "Le syndrome d’Angelman est une maladie génétique rare liée à une anomalie du gène UBE3A porté par le chromosome maternel, ce qui entraîne de graves dysfonctionnements au niveau cérébral et un retard global du développement psychomoteur des personnes atteintes.\n" +
                        "\n" +
                        "L’AFSA compte aujourd’hui plus de 600 familles adhérentes.\n" +
                        "\n" +
                        "Les buts de l’association :\n" +
                        "\n" +
                        "fournir information, entraide et soutien moral aux familles ayant à leur charge une personne atteinte du syndrome d’Angelman.\n" +
                        "faire connaître le syndrome d’Angelman et d’encourager la recherche médicale sur cette maladie.\n" +
                        "la mobilisation des financements privés et publics, afin de permettre le lancement de programmes de recherche à hauteur des besoins, d’apporter une aide directe aux personnes atteintes du syndrome d’Angelman ou à leur famille.\n" +
                        "l’établissement d’un annuaire interne diffusable aux membres de l’association.\n" +
                        "former les professionnels et les parents aux méthodes éducatives adaptées au syndrome d’Angelman afin d’améliorer la prise en charge éducative des enfants atteints.\n" +
                        "toute autre activité susceptible de concourir à la réalisation des présents buts." ,"https://afsa.france-assos-sante.org/wp-content/uploads/sites/30/2019/01/afsa-logo-2018-300x211.png", "Association Française du Syndrome d'Angelman"},
                {"16", "AFSEP","1","L’AFSEP est présente sur l’ensemble du territoire grâce à ses 115 délégués départementaux. Pour répondre à son objectif d’aide aux personnes malades, l’AFSEP s’est dotée de structures animées par des professionnels spécialisés et des bénévoles motivés.\n" +
                        "\n" +
                        "L’AFSEP a 4 axes prioritaires :\n" +
                        "\n" +
                        "l’action sociale en faveur des personnes malades et de leurs aidants,\n" +
                        "l’aide à la création et la gestion de centres spéciﬁques de soins et d’hébergement pour les personnes atteintes de Scléroses En Plaques,\n" +
                        "le soutien à la recherche en science sociale.\n" +
                        "l’information et la formation des acteurs intervenants auprès des personnes atteintes de SEP, tant au domicile qu’en institution."  ,"https://afsep.fr/asso/wp-content/uploads/2023/10/logo_AFSEP_Octobre2020.webp", "Association Française des Sclérosés en Plaques"},
                {"17", "AFVD", "2" ,"L’AFVD est une association de patients pour les patients atteints de douleurs chroniques, de type loi de 1901 créée en décembre 2006.\n" +
                        "\n" +
                        "Ses missions :\n" +
                        "\n" +
                        "Aider les patients atteints de douleurs chroniques et/ou de souffrances psychiques à devenir acteurs de leur parcours de soins en les sortant de leur isolement, en les écoutant, en les accompagnant, en soutenant leurs proches et en les informant des moyens existant pour les soulager.\n" +
                        "Travailler auprès des professionnels de santé pour compléter la prise en charge des douleurs chroniques en apportant l’expertise des patients sur le terrain.\n" +
                        "Intervenir auprès des décideurs en Santé publique pour représenter les patients, faire reconnaître le syndrome douloureux chronique comme une maladie et améliorer l’accès aux soins pour tous sur tout le territoire, en intégrant les enjeux économiques et sociaux liés à l’évolution de la population.\n" +
                        "Informer tous les publics de l’existence des douleurs chroniques et des souffrances psychiques associées, et les sensibiliser sur leur impact sur la vie des patients et de leur entourage.","https://www.association-afvd.com/images/afvd-logo-couleur-petit.png", "Association Francophone pour Vaincre les Douleurs"},
                {"18", "AFVS", "2","L’AFVS a pour mission de combattre le saturnisme et de défendre les intérêts des familles touchées par la maladie. Elle a pour objectifs d’obtenir des pouvoirs publics une véritable politique de santé publique, des mesures de prévention et de réparation, le relogement prioritaire et urgent des familles et une indemnisation des victimes." ,"https://afvs.france-assos-sante.org/wp-content/uploads/sites/60/2019/01/logo-AFVS-web-200x120.jpg", "Association des Familles Victimes du Saturnisme"},
                {"19", "AIDES","1","Créée en 1984, AIDES est la première association française de lutte contre le sida. 1500 militants, volontaires et salariés, se mobilisent chaque jour dans plus de 70 villes de France. AIDES adapte ses actions de soutien et de prévention selon l’évolution de l’épidémie. L’association défend dans la proximité le droit des personnes et combat l’exclusion. À partir des besoins des personnes séropositives recensés lors des actions de terrain, AIDES intervient auprès des pouvoirs publics pour faire évoluer la législation et le système de santé lorsqu’ils induisent l’inégalité d’accès aux soins ou aux droits. Servir de laboratoire d’idées, développer des projets pilotes, mener des actions innovantes en matière de réduction des risques de contamination est également au cœur des missions de l’association.\n" +
                        "\n" +
                        "A l’international, AIDES accompagne plus de 40 associations locales de lutte contre le sida dans une vingtaine de pays en Afrique.\n" +
                        "\n" +
                        "Toutes les actions de AIDES s’appuient sur une éthique dont AIDES ne s’est jamais départie depuis sa création : indépendance idéologique, confidentialité, respect de l’identité de chacun, non-jugement et liberté d’expression."  ,"https://www.aides.org/themes/custom/aides/public/images/general/logo.png", "Association de lutte contre le sida"},
                {"20", "AINP", "2","L’Association d’Information sur la Névralgie Pudendale et les Douleurs Pelvi-Périnéales (AINP), association agréée par le Ministère de la Santé, a pour mission principales de : 1/ Faire connaître et reconnaître cette pathologie lourde et invalidante\u200B 2/ Informer, orienter, conseiller, accompagner et soutenir les malades et leurs proches 3/ Sensibiliser le public au respect des personnes en situation du handicap, lutter contre toute forme de discrimination en lien avec le handicap." ,"https://app.assoconnect.com/services/storage?id=5348824&type=picture&secret=4duN7vCS7IZGlKLyk1rPmYXX4xyuyYv5YqAjLvoo&timestamp=1739992941", "Association d'Information sur la Névralgie Pudendale"},
                {"21", "AEJS","7" ,"La Fédération nationale Alcool Ecoute Joie & Santé dite « Alcool Ecoute FNJS » est un groupement d’associations d’aide aux personnes en difficultés avec l’alcool, qui a été fondée en 1964.\n" +
                        "\n" +
                        "Ses objectifs :\n" +
                        "\n" +
                        "Faire de la prévention (primaire, secondaire, tertiaire) en matière d’alcool.\n" +
                        "Etre à l’écoute des souffrances.\n" +
                        "Accompagner vers une vie meilleure après le sevrage, si possible joyeuse, sachant que l’arrêt de l’alcool permet un rétablissement physique et psychique souvent spectaculaire." ,"https://www.alcoolecoute.com/images/logo_alcool_ecoute.png", "Fédération nationale Alcool Ecoute Joie & Santé"},
                {"22", "AMR","1","Association loi 1901, l’Alliance Maladies Rares, créée le 24 février 2000, rassemble plus de 200 associations de malades et accueille en son sein des malades et familles isolés, « orphelins » d’associations. Elle représente environ 2 000 pathologies rares et 2 millions de malades.\n" +
                        "\n" +
                        "Elle a pour mission de :\n" +
                        "\n" +
                        "faire connaître et reconnaître les maladies rares sur leurs enjeux scientifiques, sanitaires et sociaux, ainsi que les personnes qu’elles concernent, auprès du public et des pouvoirs publics,\n" +
                        "améliorer la qualité de vie et l’espérance de vie des personnes malades en contribuant à un meilleur accès à l’information, au diagnostic, aux soins, aux droits, à la prise en charge et à l’insertion,\n" +
                        "aider les associations à remplir leurs propres missions en étant pour elles un lieu d’accueil et de ressources,\n" +
                        "promouvoir la recherche scientifique et clinique afin de donner l’espoir de guérison.\n" +
                        "L’Alliance Maladies Rares s’est enfin imposée comme un porte-parole national capable d’influer sur les politiques concernant les maladies rares, tant au niveau national que régional."  ,"https://alliance-maladies-rares.france-assos-sante.org/wp-content/uploads/sites/72/2019/01/logo-AMR-200x185.jpg", "Alliance Maladies Rares"},
                {"23", "Amadys","1","L’Association des Malades Atteints de Dystonie (AMADYS) est une association d’intérêt général, sans but lucratif, de personnes souffrant de dystonie (trouble du tonus musculaire lié à un mauvais signal envoyé par le cerveau) ou de spasme hémifacial (contracture involontaire et brève des muscles d’un seul côté du visage). Elle a été créée en 1987 et regroupe près de 2.000 adhérents dont 80 délégués répartis sur toute la France."  ,"https://amadys.fr/wp-content/themes/amadys/images/logo-amadys.png", "Association des Malades Atteints de Dystonie"},
                {"24", "AMALYSTE","1","AMALYSTE est l’association des victimes des syndromes de Lyell et de Stevens-Johnson. Fondée en 1999 et constituée en 2002, elle a accompagnée à ce jours plusieurs centaines de victimes.\n" +
                        "\n" +
                        "Ses objectifs :\n" +
                        "\n" +
                        "Rompre l’isolement des malades\n" +
                        "Réinsertion et indemnisation des personnes malades et handicapées du fait de ces syndromes\n" +
                        "Promouvoir la recherche médicale fondamentale et thérapeutique."  ,"https://www.amalyste.fr/wp-content/uploads/2023/11/2023-11-12-Banniere-site-web.jpg", "Association des victimes des syndromes de Lyell et de Stevens-Johnson"},
                {"25", "ANDAR", "1","L’ANDAR est une association régie par la loi de 1901 créée en 1984 pour lutter contre la polyarthrite rhumatoïde (PR). Animée et gérée par des polyarthritiques bénévoles, elle regroupe près de 4 000 adhérents en France métropolitaine et rassemble une vingtaine d’antennes régionales réparties sur l’ensemble du territoire national, mais également présente dans plusieurs pays étrangers.\n" +
                        "\n" +
                        "Ses objectifs :\n" +
                        "\n" +
                        "mettre à la disposition des personnes atteintes de PR et de leur entourage l’information sur la PR et ses conséquences ;\n" +
                        "faciliter le dialogue entre les malades et tous les professionnels de la santé impliqués dans la prise en charge des patients ;\n" +
                        "défendre les droits des malades en sensibilisant les autorités publiques et les tutelles aux problèmes posés par cette maladie ;\n" +
                        "stimuler et contribuer financièrement à la recherche médicale ;\n" +
                        "sensibiliser le grand public." ,"https://www.polyarthrite-andar.org/images/imagecache/0x97/png/template_images_Logo_ANDAR.webp", "Association Nationale de Défense contre l'Arthrite Rhumatoïde"},
                {"26", "APAJH", "3","L’APAJH, Association Pour Adultes et Jeunes Handicapés, fait avancer la réflexion et l’action pour assurer à chacun un égal accès aux droits : droit à l’école, droit à la vie professionnelle, droit à la vie sociale et culturelle, droit à une vie intime et affective.\n" +
                        "\n" +
                        "Reconnue d’utilité publique, l’APAJH est le premier organisme en France à considérer et accompagner tous les types de handicap : physiques, intellectuels, sensoriels, psychiques, cognitifs, polyhandicaps, troubles de santé invalidants (…)." ,"https://www.apajh.org/uploads/2023/02/logo-fede-apajh.jpg", "Association Pour Adultes et Jeunes Handicapés"},
                {"27", "APF France handicap","3" ,"APF France handicap est la plus importante organisation française, reconnue d’utilité publique, de défense et de représentation des personnes en situation de handicap et de leurs proches. \n" +
                        "\n" +
                        "Créée en 1933, connue et reconnue jusqu’en avril 2018 sous le nom d’Association des paralysés de France, APF France handicap rassemble aujourd’hui près de 100 000 acteurs : adhérents, élus, salariés, bénévoles et volontaires, usagers, sans compter ses dizaines de milliers de donateurs et sympathisants.\n" +
                        "\n" +
                        "APF France handicap porte des valeurs humanistes, militantes et sociales et un projet d’intérêt général, celui d’une société inclusive et solidaire.\n" +
                        "L’association agit pour l’égalité des droits, la citoyenneté, la participation sociale et le libre choix du mode de vie des personnes en situation de handicap et de leur famille." ,"https://apf-france-handicap.france-assos-sante.org/wp-content/uploads/sites/78/2019/01/Logo-bloc-APF-France-handicap-bichromie-200x126.jpg", "Association Pour Adultes et Jeunes Handicapés"},
                {"28", "APODEC","2","L’Association de POrteurs de Dispositifs Electriques Cardiaques (APODEC) a été créée en mars 2000 par deux porteurs de défibrillateurs.\n" +
                        "\n" +
                        "L’association représente les 80.000 porteurs de défibrillateurs en France et dans les DOM et depuis Novembre 2019, l’APODEC accueille les porteurs de stimulateurs cardiaques (ou Pacemakers) soient 700.000 personnes.\n" +
                        "\n" +
                        "Le bureau est composé d’un président, d’un Secrétaire Général, d’un Vice-Président, d’une Secrétaire et d’une Trésorière.\n" +
                        "\n" +
                        "Son conseil d’administration est composé de 8 membres.\n" +
                        "\n" +
                        "Un réseau de délégués est représenté dans chaque région."  ,"https://app.assoconnect.com/services/storage?id=4320875&type=picture&secret=8cfjzkPPwfJmJ4sjEbmfnRkEgHnX12LPf0Oz9KDS&timestamp=1713532804&size=small", "Association des porteurs de dispositifs électriques cardiaques"},
                {"29", "ARGOS 2001","4","Association d’aide aux personnes atteintes de troubles bipolaires (maniaco-dépressifs) et à leur entourage, créée en 2001. Ses activités essentielles consistent dans des groupes de paroles pour les patients et leurs proches ainsi que des conférences faites par des psychiatres spécialisés sur les troubles bipolaires.\n" +
                        "\n" +
                        "Environ une soixantaine de bénévoles sont impliqués dans le fonctionnement de l’association, elle compte autour de 1000 adhérents et plus de 4 000 sympathisants."  ,"https://argos2001.france-assos-sante.org/wp-content/uploads/sites/82/2019/01/argos2001-Logo-200x64-160x51.jpg", "Association d’aide aux personnes atteintes de troubles bipolaires (maniaco-dépressifs) et à leur entourage"},
                {"30", "ARSLA", "2","La Sclérose Latérale Amyotrophique (SLA) ou maladie de Charcot fait partie des affections dégénératives du système nerveux central se traduisant par la disparition progressive des cellules qui commandent les muscles volontaires. Pour la combattre, l’ARSLA propose de multiples actions en faveur des personnes concernées (malades, familles, soignants), soutien aux recherches et structures spécialisées.\n" +
                        "\n" +
                        "Le défi permanent de l’ARSLA, sur tout le territoire français, est de répondre à l’évolution des besoins des malades pour favoriser l’accès aux soins, pour améliorer leur qualité de vie et celle de leurs proches ainsi que répondre aux insuffisances des pouvoirs publics par le plaidoyer politique ou la mobilisation financière." ,"https://www.arsla.org/app/themes/arsla/images/logo.png", "Association pour la Recherche sur la Sclérose Latérale Amyotrophique"},
                {"31", "ASBH","3","L’Association nationale Spina Bifida et Handicaps Associés (ASBH) s’investit dans le soutien et le développement de la recherche sur les défauts de tube neural (DTN) en général et le spina bifida en particulier, sans oublier l’incontinence sphinctérienne.\n" +
                        "\n" +
                        "Son principal objectif est de motiver et financer des programmes de recherche sélectionnés par son comité médical national mais également de permettre aux malades et à leur famille un dialogue et un accès aux services proposés grâce à ses délégations régionales et ses rubriques d’entraide.\n" +
                        "\n" +
                        "L’ASBH propose :\n" +
                        "– un service national d’aide et de conseils à l’incontinence sphinctérienne,\n" +
                        "– Allo SB Santé, une plateforme de médecins bénévoles qui répond aux questions médicales,\n" +
                        "– une publication trimestrielle, la Lettre du Spina Bifida,\n" +
                        "– des stages de formations pour bénévoles, pour aidants familiaux, sur « la vie affective et sexuelle »."  ,"https://www.spina-bifida.org/wp-content/uploads/2019/10/Logo-ASBH-website-2019.png", "Association nationale Spina Bifida et Handicaps associés"},
                {"32", "ASF", "1" , "Créée en 1989, l’Association des Sclérodermiques de France (ASF) est une association composée de malades atteints de sclérodermie, de leurs conjoints, de leurs familles, de leurs amis, de sympathisants, qui unissent leurs forces pour tenter de vaincre la sclérodermie, une maladie rare, auto-immune, caractérisée par une sclérose progressive du derme et parfois des viscères. Elle compte 1100 adhérents à ce jour.","https://www.association-sclerodermie.fr/wp-content/uploads/2023/01/nouveau-logo-2023-reduit-334x350.jpg", "Association des Sclérodermiques de France"},
                {"33", "ASFC", "1","L’ASFC a pour but et pour vocation :\n" +
                        "\n" +
                        "D’accueillir et d’informer les malades et leur entourage sur ce syndrome ou un des syndromes associés ;\n" +
                        "D’orienter les malades vers les médecins et services compétents de leur région afin d’obtenir un diagnostic fiable ;\n" +
                        "De participer, grâce aux adhésions et aux dons à des travaux de recherche ;\n" +
                        "D’alerter les pouvoirs publics sur les problèmes rencontrés par les malades pour la reconnaissance de leur maladie ;\n" +
                        "D’informer et orienter les malades vers les services administratifs ou organismes compétents pour la reconnaissance de leur maladie ;\n" +
                        "De favoriser des échanges ou des partenariats avec d’autres associations susceptibles de les aider dans leurs démarches administratives ;\n" +
                        "De donner accès aux adhérents à toutes les informations ou avancées médicales ayant fait l’objet de publications fiables, susceptibles de les aider dans leurs parcours médical." ,"https://asfc.france-assos-sante.org/wp-content/uploads/sites/92/2019/01/Logo-ASFC-haute-def-2018-300x158.png", "Association française du Syndrome de Fatigue Chronique"},
                {"34", "ABF","2" ,"L’ABF est présente sur tout le territoire et regroupe des bénévoles dédiés à l’information des brûlés et de leur famille. Notre siège social se situe à Paris. Nous assurons des permanences dans les Centres de traitement des Brûlés, Soins de Suite et de Réadaptation, Centres de cure thermale." ,"https://abf-association-brules-france.france-assos-sante.org/wp-content/uploads/sites/135/2022/10/logo.png", "Association des Brûlés de France"},
                {"35", "AFRH","7","L’Association Française pour la Recherche sur l’Hidrosadénite (AFRH) est une organisation dédiée à la sensibilisation, à la recherche et au soutien des personnes affectées par l’Hidrosadénite Suppurée, également connue sous le nom de maladie de Verneuil.\n" +
                        "\n" +
                        "Fondée en février 2000 pour combler le manque de connaissances et de ressources autour de cette maladie, l’AFRH œuvre pour améliorer la qualité de vie des patients, promouvoir la recherche scientifique et favoriser la reconnaissance de l’Hidrosadénite Suppurée en tant que problème de santé sérieux."  , "https://www.afrh.fr/files/drag-and-drop-img-436.png", "Association Française pour la Recherche sur l'Hidrosadénite"},
                {"36", "AT","5" ,"Actions Traitements est une association créée en 1991 à l’initiative de personnes vivant avec le VIH. Elle rassemble aujourd’hui des patients et des personnes concernées par le VIH et/ou co-infectées aux hépatites virales. Elle vulgarise l’information scientifique et médicale sur le VIH/sida et les co-infections aux hépatites." ,"https://actions-traitements.org/images/AT_logo.png", "Actions Traitements"},
                {"37", "Autisme France","1" ,"Association de parents reconnue d’utilité publique, Autisme France représente environ 9 000 familles au sein de son mouvement associatif, composé de plus de 125 associations membres, partenaires et affiliées. Elle est née en 1989 d’un constat : les personnes autistes en France n’ont pas toujours droit à un diagnostic correct et à un accompagnement décent tout au long de leur vie. Certaines des associations partenaires gèrent des structures et services médico-sociaux.\n" +
                        "\n" +
                        "Ses missions ? Défendre les personnes autistes, les représenter au niveau national dans les différentes instances, promouvoir des services et structures spécifiques, développer l’information et la formation des parents et professionnels, défendre les usagers autistes dans le système de santé et les services médico-sociaux. Autisme France a amorcé une révolution culturelle pour sortir l’autisme de l’institution psychiatrique : elle se bat pour que les financements aillent à l’accompagnement éducatif et professionnel, à l’intégration sociale la plus large possible." ,"https://www.autisme-france.fr/f/d8a9e3456da753f26b7d19471bd21cc854b01e50/logo-autisme-france.png", "Autisme France"},
                {"38", "AVIAM","2","L’AVIAM agit au quotidien depuis 1986 pour la défense et le soutien des victimes d’accidents médicaux. Son action consiste à aider, à soutenir et à informer les victimes et leur famille dans leurs démarches pour obtenir réparation de leurs préjudices. Elle siége aux Commissions régionales d’indemnisation et de conciliation (CRCI)."  ,"https://aviam.france-assos-sante.org/wp-content/uploads/sites/96/2019/01/logo-aviam-161x200.jpg", "Association d'aide aux victimes d'accidents médicaux et à leur famille"},
                {"39", "CADUS", "5","L’Association CADUS apporte conseils et assistance pour l’obtention du dossier médical et l’élaboration de demande(s) d’indemnisation. Ses conseils vont étudier tout dossier médical pour déterminer l’existence des différents préjudices.\n" +
                        "\n" ,"https://www.france-assos-sante.org/wp-content/uploads/2018/11/cadus-200x136.png", "Conseil Aide & Défense des Usagers de la Santé"},
                {"40", "CLCV", "7","La CLCV (Consommation, logement et cadre de vie) est une association nationale qui défend exclusivement les intérêts spécifiques des consommateurs et des usagers.\n" +
                        "\n" +
                        "Créée en 1952, voulue et maintenue indépendante de toute influence politique, syndicale, professionnelle ou religieuse, la CLCV intervient, aux niveaux national et local, sur tout ce qui concerne la défense des consommateurs (agrément en 1975), la représentation des locataires (agrément en 1982), l’éducation populaire (agrément en 1983), la défense de l’environnement, l’action éducative complémentaire de l’enseignement public (agrément en 1996) et la représentation des usagers du système de santé dans les instances hospitalières ou de santé publique (2006)." ,"https://clcv-isere.org/wp-content/uploads/2022/03/logo-clcv-isere.webp", "Association nationale de défense des consommateurs et usagers"},
                {"41", "CNAFAL","7","Le Cnafal oeuvre pour la défense des familles dans leur bien-être et tout ce qui y concourt.\n" +
                        "\n" +
                        "Ses objectifs :\n" +
                        "\n" +
                        "Défendre les intérêts moraux et matériels des familles dans le respect et la promotion d’une certaine éthique de la consommation (développement durable, protection des travailleurs…).\n" +
                        "Protéger la nature et l’environnement et améliorer le cadre de vie.\n" +
                        "Représenter et défendre les locataires ou les accédants à la propriété (action civile devant les tribunaux)." ,"https://www.cnafal.org/wp-content/themes/cnafal/images/familles_laiques.gif", "Conseil National des Associations Familiales Laïques"},
                {"42", "CNAFC","7","La Confédération nationale des Associations familiales catholiques (CNAFC) agit pour promouvoir la famille au sein de la société, en se référant à l’enseignement social et familial de l’Eglise, au niveau national (notamment en tant que membre de l’UNAF) et au niveau international. Mouvement familial reconnu d’utilité publique par les pouvoirs publics français depuis 2005 et association de consommateurs, elle a signé, en 1992, un protocole avec la Commission Episcopale de la Famille de la Conférence des Evêques de France qui éclaire son rôle et sa collaboration avec les instances ecclésiales nationales et locales.\n" +
                        "\n" +
                        "Présentes sur tout le territoire français, y compris dans les DOM-TOM, les AFC représentent 30 000 familles adhérentes, réparties dans près de 350 AFC locales et 74 Fédérations départementales."  ,"https://www.afc-france.org/wp-content/uploads/2020/10/logo-AFC.png", "Confédération des associations familiales catholiques"},
                {"43", "CNAO","5","Le CNAO est un collectif regroupant des associations de patients souffrant de surpoids et/ou d’obésité. Il est le lien entre les institutions et les associations en région, coordonne les actions au niveau national et local, apporte son expertise sur l’obésité et les problèmes de surpoids (sur les aspects psychologiques, nutritionnels, sportifs et de santé).\n" +
                        "\n" +
                        "Depuis plusieurs années, le CNAO a su s’imposer comme un acteur clé de la lutte contre l’obésité en participant notamment aux auditions permettant d’aboutir au plan Obésité et aux actions qui en découlent."  ,"https://cnao.fr/wp-content/uploads/2021/02/cnao_logo.jpg", "Collectif National des Associations d'Obèses"},
                {"44", "E3M","2","L’association E3M a été créée en mai 2001. Elle regroupe des personnes atteintes de Myofasciite à Macrophages (pathologie induite par l’aluminium utilisé comme adjuvant dans les vaccins) ainsi que des membres de leurs familles. E3M ne s’oppose pas au principe même de la vaccination, mais se mobilise pour l’utilisation de vaccins sans aluminium."  ,"https://www.asso-e3m.fr/wp-content/uploads/2019/10/Logo-E3M-carre%CC%81-RVB-300x300.jpg", "Association d'Entraide aux Malades de Myofasciite à Macrophages"},
                {"45", "EFAPPE","7","EFAPPE est la fédération nationale d’associations en faveur des Personnes handicapées par une épilepsie sévère (pharmaco-résistante). Elle rassemble 18 associations pour une meilleure prise en charge globale des personnes handicapées par des épilepsies sévères.\n" +
                        "La fédération accompagne ses associations membres pour faire reconnaître et prendre en compte les spécificités des épilepsies."  ,"https://www.efappe.epilepsies.fr/wp-content/uploads/2014/09/cropped-cropped-Banniere-bis.jpg", "Fédération des Associations de Personnes Handicapées par des Épilepsies Sévères"},
                {"46", "EndoFrance","1" ,"EndoFrance est la première association de lutte contre l’endométriose créée en France en 2001. Depuis 2018, elle est agréée par le ministère de la Santé. Son équipe de bénévoles, son comité scientifique composé de médecins spécialistes reconnus pour leurs compétences, sa Marraine Laëtitia Milot et son parrain Thomas Ramos, militent ensemble pour faire connaitre cette maladie.\n" +
                        "\n" +
                        "EndoFrance multiplie les actions de soutien et d’information pour les personnes atteintes d’endométriose. Chaque années, des centaines d’actions sont mises en place : événements locaux, conférences médicales, tables rondes avec des professionnels de santé. Depuis 2016, EndoFrance apporte un soutien financier aux projets de recherches scientifiques dédiés à l’endométriose. Elle a aussi rédigé un chapitre des recommandations pour la pratique clinique de l’endométriose (HAS/CNGOF), et a collaboré avec le Ministère pour la mise en place de filières de soin endométriose… et pour définir la stratégie nationale de lutte contre l’endométriose." ,"https://endofrance.org/wp-content/uploads/2024/03/logo-2024-endo.png", "EndoFrance"},
                {"47", "ENDOmind","1" ,"ENDOmind France, agréée par le ministère de la santé, participe aux côtés des autres acteurs de la maladie, à la sensibilisation de la société et au développement du lien entre les associations, les professionnels de la santé et les patientes. Nos objectifs sont de permettre de mieux faire connaître la maladie, réduire le délai de diagnostic, améliorer la prise en charge globale des malades et encourager le développement de la recherche en faisant de l’endométriose un véritable enjeu de société et de santé publique." ,"https://static.wixstatic.com/media/ebf679_8fc531e6bffb4f8688f8d28bbbdf9e54~mv2.jpg/v1/fill/w_203,h_80,al_c,q_80,usm_0.66_1.00_0.01,enc_avif,quality_auto/LOGO%20ENDOmind%20HD.jpg", "ENDOmind"},
                {"48", "Entraid'addict","7" ,"Entraid’addict est une association loi 1901, à but non lucratif reconnue d’utilité publique agréée Jeunesse et Éducation Populaire, Représentant des usagers, Organisme de formation. Implantée sur l’ensemble du territoire national avec 7 associations régionales, 58 associations départementales et 225 lieux d’accueil. Au plan national, la Fédération compte 4 859 adhérents et 40 000 bénéficiaires.\n" +
                        "\n" +
                        "L’accompagnement des personnes en prise avec des conduites addictives et de leur entourage\n" +
                        "\n" +
                        "Le domaine d’action d’Entraid’addict couvre aujourd’hui toutes formes de conduite addictive, y compris le champ des addictions comportementales : usage et mésusage d’alcool, stupéfiants, tabac, médicaments, jeux, sexe et autres addictions sans produit. L’accompagnement est abordé dans une perspective globale, psychologique, médicale et sociale. Il est basé sur l’entraide et le soutien mutuel par les pairs.\n" +
                        "\n" +
                        "L’accompagnement est basé sur l’accueil, l’écoute de la personne par des entretiens individuels, l’orientation vers les structures de consultation et de soin en addictologie et l’animation d’espaces de paroles. Nos espaces de paroles animés par des bénévoles favorisent l’expression de chacun, on peut s’y exprimer librement de manière confidentielle, être écouté et compris et trouver de la motivation et des encouragements.\n" +
                        "\n" +
                        "La prévention et la réduction des risques\n" +
                        "\n" +
                        "Forte de son expérience, la fédération mène aussi des actions de prévention et de réduction des risques et des dommages tant en milieu scolaire que festif, judiciaire et professionnel." ,"https://app.assoconnect.com/services/storage?id=2514864&type=picture&secret=YuqLOHnl9CXqdXBWml8PfxNLhLLyysVIubCZ3i92&timestamp=1657644514&size=small", "Entraid'addict"},
                {"49", "Épilepsie France","1","Épilepsie-France est une association nationale régie par la loi du 1er juillet 1901; elle a été déclarée le 4 novembre 2004, en vue de réaliser la fusion de deux associations préexistantes, l’Association pour la Recherche, Pour l’Éducation et l’Insertion des Jeunes Épileptiques (ARPEIJE), créée en 1988 et le Bureau Français de l’Épilepsie (BFE), créé en 1991; la fusion au sein de l’association Épilepsie-France est effective depuis le 1er janvier 2006. Elle regroupe des personnes épileptiques et leurs proches, des professionnels bénévoles et d’autres associations, dont elle fédère les activités.\n" +
                        "Épilepsie-France travaille exclusivement au profit des personnes épileptiques et de leurs proches, en vue d’améliorer leur qualité de vie. Pour cela elle rassemble, outre les personnes épileptiques et leurs proches, les professionnels et tous les organismes intéressés par l’épilepsie."  ,"https://www.epilepsie-france.com/wp-content/uploads/2022/07/logo-epilepsie.png", "Épilepsie France"},
                {"50", "Familles de France", "7","Familles de France est « le seul mouvement familial, libre de tout lien politique, confessionnel, syndical, idéologique ou géographique ». Il est organisé en plus de 400 associations selon le modèle de l’association loi 1901.\n" +
                        "\n" +
                        "Les actions de Familles de France sont multiples. Toujours orientées en faveur des familles, ces actions se déclinent sur des thèmes très variés: environnement familial, logement, aide aux consommateurs, sécurité domestique, formation, accompagnement, conférences…" ,"https://www.familles-de-france.org/themes/custom/bootstrap_fdf/images/logo.png", "Familles de France"},
                {"51", "Familles Rurales", "7","Familles Rurales est une association nationale reconnue d’utilité publique qui agit en faveur des familles sur tout le territoire, en milieu rural et périurbain.\n" +
                        "\n" +
                        "Avec 160 000 familles adhérentes, 2 200 associations locales, 83 fédérations départementales et régionales, 40 000 bénévoles et 17 000 salariés, c’est le premier Mouvement familial associatif de France, mais aussi un acteur incontournable de l’économie sociale et solidaire et de l’éducation populaire. Familles Rurales est agréé association de défense des consommateurs.\n" +
                        "\n" +
                        "Pluraliste, indépendant et laïc, il porte un projet humaniste et social fondé sur la famille, les territoires et la vie associative." ,"https://www.famillesrurales.org/lefenouiller/lefenouiller/sites/multisite.famillesrurales.org._www/files/styles/logo/public/logo_institutionnel_blanc2.png?itok=ON3WOdcm", "Familles Rurales"},
                {"52", "FFD","1","Fondée en 1938, et reconnue d’utilité publique en 1976, la Fédération Française des Diabétiques est une association de patients au service des patients. Présente sur l’ensemble du territoire, y compris les DOM, elle fédère près de 100 associations et délégations locales animées par des bénévoles pour y mener des actions de terrain, soutenues par l’équipe du siège national. Véritable acteur de santé, la Fédération est pleinement engagée pour participer à la démocratie sanitaire aux côtés de toutes les parties prenantes. Elle est co-fondatrice de France Assos Santé et siège à la Vice- Présidence de son Conseil d’Administration. Elle est membre fondateur de la Fédération Internationale du Diabète et elle agit pour faire bouger les lignes aux niveaux européen et international.\n" +
                        "\n" +
                        "Elle a pour missions :\n" +
                        "– d’informer, d’accompagner et de prévenir les personnes atteintes de diabète ou à risque, ainsi que leur entourage ;\n" +
                        "– de défendre individuellement et collectivement les personnes atteintes du diabète pour faire reconnaître leurs droits, leur permettre de disposer de soins de qualité, au travers des actions de plaidoyer et d’accompagnement des patients dans leurs démarches ;\n" +
                        "– de soutenir la recherche scientifique et médicale et l’innovation avec son Diabète LAB pour améliorer la qualité de vie des patients et œuvrer à la guérison du diabète."  ,"https://www.federationdesdiabetiques.org/public/styles/logo/public/logos/logo_ffd.png?itok=e_twXYuk", "Fédération Française des Diabétiques"},
                {"53", "FFDSB","7","La Fédération Française pour le Don de Sang Bénévole est le partenaire de collecte historique de l’EFS. Depuis sa création en 1949, la FFDSB est un acteur incontournable de la transfusion sanguine en France.\n" +
                        "\n" +
                        "Elle réunit 750 000 adhérents sur le territoire et 2850 associations locales. Elle représente les donneurs de sang auprès des pouvoirs publics. Elle participe activement à organiser des collectes et recruter de nouveaux donneurs et bénévoles."  ,"https://www.federationdesdiabetiques.org/public/styles/logo/public/logos/logo_ffd.png?itok=e_twXYuk", "Fédération Française pour le Don de Sang Bénévole"},
                {"54", "FFSA","7","Créée par des parents d’enfants, adolescents et adultes avec autisme pour créer des conditions de vie meilleures pour ces derniers, quels que soient leur âge et la sévérité de leurs troubles, la Fédération Française Sésame-Autisme comprends un réseau de près de 32 associations, 4.000 salariés et une centaine d’établissements pour personnes avec autisme."  ,"https://sesameautisme.fr/wp-content/uploads/2017/03/logo.jpg", "Fédération Française Sésame Autisme"},
                {"55", "FNAS","7","La Fédération Nationale des Amis de la Santé est un groupement d’Associations Départementales d’information, de prévention et de lutte contre les addictions et plus spécifiquement l’alcoolisme. Au service des malades et de l’entourage depuis 1978. Inscrite au registre des associations du Tribunal d’instance de SCHILTIGHEIM – Volume XIX n° 975 (loi 1908 droit local Alsace – Moselle).\n" +
                        "\n" +
                        "Elle représente auprès des services publics, semi-publics, organismes de tutelles, organismes médico-sociaux, associations familiales et autres, toutes les Associations affiliées qui offrent leur aide aux personnes dont le développement personnel est limité par la consommation de substances psycho-actives et plus particulièrement l’alcool.\n" +
                        "\n" +
                        "Cette aide s’adresse au patient comme à son entourage.\n" +
                        "\n" +
                        "A cette fin, la Fédération développe des actions de formation, d’éducation à la santé, de prévention, à destination des membres des associations affiliées, en partenariat avec d’autres organismes ou associations poursuivant le même but.\n" +
                        "\n" +
                        "Elle donne les moyens d’expression aux associations membres par le biais d’un bulletin trimestriel, d’un site internet et d’une manifestation à périodicité quadriennale."  ,"https://www.lesamisdelasante.org/wp-content/themes/a3web/img/logo_menu.png", "Fédération Nationale des Amis de la Santé"},
                {"56", "FFCM","7","Fondée en 2000, la Fédération Française des Curistes Médicalisés (FFCM) est la seule association nationale vouée à la défense des curistes et du thermalisme social et médicalisé qui soit agréée par le Ministère de la Santé.\n" +
                        "\n" +
                        "\u200BNous sommes un des membres fondateurs de l’Union Nationale des Associations Agréées du Système de Santé (France Assos Santé) en 2017\n" +
                        "\n" +
                        "Nous représentons officiellement les intérêts des curistes assurés sociaux auprès des organismes publics et privés.\n" +
                        "\n" +
                        "Nous oeuvrons pour que l’ensemble des acteurs s’unissent pour sauvegarder et développer le thermalisme social et médicalisé de France.\n" +
                        "\n" +
                        "Nous accueillons les curistes assurés sociaux et tous les amis du thermalisme social et médicalisé.\n" +
                        "\n" +
                        "La FFCM rassemble 1 300 adhérents et 3 500 sympathisants répartis dans 70 stations et informe 80 000 curistes.\n" +
                        "\n" +
                        "La FFCM est gérée par des bénévoles et l’essentiel de nos ressources provient des curistes, ce qui fonde notre indépendance."  ,"https://static.wixstatic.com/media/cdd428_4eba4ddbe9f54adfbfbf59942a95a770.png/v1/fill/w_220,h_210,al_c,q_85,usm_0.66_1.00_0.01,enc_avif,quality_auto/cdd428_4eba4ddbe9f54adfbfbf59942a95a770.png", "Fédération Française des Curistes Médicalisés"},
                {"57", "FGCP", "7","L’objectif principal de l’association est d’obtenir une meilleure représentation des greffés du Cœur ou des Poumons auprès des différents Ministères et institutions.\n" +
                        "\n" +
                        "L’idée de créer une Fédération fut lancée en 1987 et un accord de principe s’établit lors d’une réunion en février 1988.\n" +
                        "\n" +
                        "Le 23 avril 1994 la Fédération Française des Associations de Greffés du Cœur ou des Poumons voyait le jour.\n" +
                        "\n" +
                        "Ce fut Claude Dorgeat, le Président de Cardio-Greffes, qui en accepta la Présidence et proposa d’héberger le siège dans ses locaux parisiens.\n" +
                        "\n" +
                        "En effet il a été considéré qu’une Fédération nationale serait plus crédible avec une adresse dans la capitale. Les statuts ont été modifiés lors des assemblées générales extraordinaires des 17 avril 1999 et 16 mai 2007 et le 04 juin 2016.\n" +
                        "L’adresse du siège social a été modifiée par l’assemblée générale de 2009." ,"https://fgcp.france-assos-sante.org/wp-content/uploads/sites/79/2019/01/logo-fgcp.jpg", "France Greffe Cœur et/ou Poumons"},
                {"58", "FibromyalgieSOS", "1","L’association FibromyalgieSOS a été créée le 24 mai 2005 afin de sortir les malades fibromyalgiques de l’isolement par le biais de l’Internet. Ses buts :\n" +
                        "\n" +
                        "Faire connaître et reconnaître la fibromyalgie auprès du grand public, des médias, du corps médical, des pouvoirs publics et participer à la recherche.\n" +
                        "Informer le malade par des informations médicales et administratives pour favoriser son implication dans son traitement : un malade bien informé est actif.\n" +
                        "Sortir le malade de l’isolement, un des piliers de la thérapie." ,"https://fibromyalgiesos.fr/rdv2/wp-content/uploads/2021/10/fibromyalgiesos-logo-mini.png", "FibromyalgieSOS"},
                {"59", "FNAPSY","4","La Fédération Nationale des Associations d’usagers en PSYchiatrie a été créée le 1er mars 1992, sous le sigle FNAP Psy (Fédération Nationale des Associations de (ex) Patients des services Psychiatriques), par trois associations d’usagers, AME (Association pour le Mieux Être), APSA (Association des Psychotiques Stabilisés Autonomes), Revivre Paris, dont le Président était Monsieur Jacques Lombard, notre actuel Président d’Honneur. La fondation de la FNAP PSY a été encouragée et soutenue par Monsieur le Professeur Edouard Zarifian et Monsieur Joël Martinez (alors Directeur du Centre Hospitalier Spécialisé Esquirol 94).\n" +
                        "\n" +
                        "La FNAPSY regroupe à ce jour, 59 associations sur toute la France, soit environ 5000 usagers.\n" +
                        "\n" +
                        "Ces associations sont toutes composées en majorité d’usagers en psychiatrie et sont dirigées par des usagers. Une de ces associations adhérentes a une dimension nationale."  ,"https://fnapsy.france-assos-sante.org/wp-content/uploads/sites/88/2019/01/Fnapsy-logo-200x108.jpg", "Fédération Nationale des Associations d’usagers en Psychiatrie"},
                {"60", "FNAR","7","La FNAR est une association régie par la loi de 1901, apolitique, non confessionnelle et autonome.\n" +
                        "\n" +
                        "Elle défend les intérêts des retraités et des personnes âgées, notamment en menant des actions auprès des Pouvoirs publics et des parlementaires.\n" +
                        "\n" +
                        "La FNAR a été créée en 1974 par des fédérations départementales de clubs de retraités, rejointes ultérieurement par des amicales et associations de retraités d’entreprises."  ,"https://fnar.info/wp-content/themes/fnar/img/logo.png", "Fédération Nationale des Associations de Retraités et préretraités"},
                {"61", "FNATH", "7","Seule association représentative au plan national de TOUTES les victimes du travail, accident ou maladie, la FNATH agit au quotidien pour faire émerger la reconnaissance de nouvelles problématiques, telles que les affections psychiques (burn-out) ou l’exposition à des pesticides ou des agents chimiques…\n" +
                        "\n" +
                        "Notre association est membre de nombreuses instances dans lesquelles elle peut s’exprimer : conseil de la CNAMTS, AGEFIPH et FIPHFP, Conseil d’orientation des conditions de travail, Santé Publique France, Conseil national consultatif des personnes handicapées….\n" +
                        "\n" +
                        "Elle participe par ailleurs activement à porter la voix des usagers du système de santé au sein de France Assos Santé, dont elle est membre fondateur, ainsi qu’au Comité d’entente des associations de personnes handicapées…" ,"https://fnath.france-assos-sante.org/wp-content/uploads/sites/86/2019/01/logo-fnath-200x201.jpg", "Association des Accidentés de la Vie"},
                {"62", "France Alzheimer", "3","France Alzheimer et maladies apparentées, créée en 1985, est la seule association de familles dans le domaine, reconnue d’utilité publique depuis 1991. Son réseau de 101 associations départementales (outre-mer y compris) lui permet d’apporter une aide quotidienne et de proximité aux personnes malades et à leurs proches aidants.\n" +
                        "\n" +
                        "L’association s’engage aux côtés des familles, des professionnels de santé et du secteur médico-social, des chercheurs, des acteurs institutionnels pour une amélioration durable de la prise en soins et de l’accompagnement des familles concernées.\n" +
                        "\n" +
                        "Ses quatre missions principales sont :\n" +
                        "\n" +
                        "l’écoute et le soutien des personnes malades et de leurs proches aidants ;\n" +
                        "la formation des aidants, des bénévoles et des professionnels de santé ou du secteur médico-social ;\n" +
                        "l’information du grand public et l’interpellation des pouvoirs publics ;\n" +
                        "le financement de la Recherche." ,"https://www.francealzheimer.org/wp-content/themes/fa/menu/img/FALogoL.png", "France Alzheimer"},
                {"63", "France Dépression","4","France dépression\n" +
                        "France Dépression, créée en 1992, est une association loi 1901\n" +
                        "sans but lucratif et reconnue d’intérêt général.\n" +
                        "\n" +
                        "France Dépression a pour mission de prévenir, d’informer, de soutenir les personnes souffrant de dépression ou de troubles bipolaires, de lutter contre la stigmatisation et de promouvoir leur dignité et le respect de leurs droits au niveau local, national et européen.\n" +
                        "\n" +
                        "L’Association agit au cœur de la cité, au travers de différentes actions, afin d’œuvrer à une meilleure prise en charge des personnes concernées ainsi qu’à une meilleure information sur les causes et les conséquences de la dépression et des troubles bipolaires. A cet effet, France Dépression a pour vocation d’être un espace ressources, physique et virtuel, rassemblant un maximum d’information disponible et adéquate sur les différentes formes de Dépression et favorisant les échanges et le partage d’expériences entre les personnes."  ,"https://www.francedepression.fr/images/interface/accueil.png", "France Dépression"},
                {"64", "France Lyme","1","Créée en 2008, France Lyme est une association de lutte contre les maladies vectorielles à tiques et MVT, dont la plus connue est la maladie de Lyme.\n" +
                        "Principale association de patients de ce domaine médical, reconnue d’intérêt général, agréée par le Ministère de la Santé, France Lyme rassemble 2000 adhérents et se déploie dans 20 sections locales.\n" +
                        "\n" +
                        "France Lyme se fixe 4 missions :\n" +
                        "\n" +
                        "Représenter et défendre les personnes souffrant de MVT\n" +
                        "Ecouter et soutenir les malades\n" +
                        "Informer sur les MVT\n" +
                        "Développer la connaissance" ,"https://francelyme.fr/site/wp-content/uploads/2019/05/Logo-bandeau-new-site-FL.jpg", "France Lyme"},
                {"65", "France Parkinson","1","L’Association France Parkinson a été créée en 1984. Reconnue d’utilité publique en 1988, elle se donne pour buts de : favoriser la recherche, soutenir les malades et leurs aidants, aider à comprendre la maladie pour vivre au mieux, former les intervenants médico-sociaux, donner aux personnes touchées des occasions et des moyens pour sortir de leur isolement.\n" +
                        "\n" +
                        "Sensibiliser les pouvoirs publics à la réalité de la maladie et la faire connaître du grand public sont aussi devenus des combats majeurs de l’association, qui a édité en 2010 un Livre blanc, ouvrage de référence sur les souffrances et les actions à mener\n" +
                        "\n" +
                        "Aujourd’hui, 150 000 personnes en France sont atteintes de la maladie de Parkinson. Environ 12 000 nouveaux cas par an sont dénombrés. Forte de ses 60 comités locaux et de son Comité scientifique, France Parkinson accompagne 10 000 adhérents et sympathisants."  ,"https://france-parkinson.france-assos-sante.org/wp-content/uploads/sites/71/2019/01/logo-france-parkinson-300x113.png", "France Parkinson"},
                {"66", "France Rein", "1","Depuis près de 50 ans, France Rein agit au service des millions de Français concernés par une maladie rénale chronique. Reconnue d’Utilité Publique et agréée par le Ministère de la Santé, notre association de patients, indépendante, s’engage contre les maladies rénales, partout et à tous les stades.\n" +
                        "\n" +
                        "Forte d’un réseau de 23 associations régionales, France Rein couvre tout le territoire français afin que ses 600 bénévoles soient au plus près des 80 000 personnes en insuffisance rénale chronique pour les représenter.\n" +
                        "\n" +
                        "Ses objectifs :\n" +
                        "– Améliorer la prévention des maladies rénales\n" +
                        "– Améliorer la qualité de vie et de traitement des patients en les aidant à construire leur projet de vie avec la maladie, soutenir leurs proches\n" +
                        "– Favoriser la transplantation rénale\n" +
                        "– Prendre part dans la définition des politiques de santé" ,"https://france-rein.france-assos-sante.org/wp-content/uploads/sites/69/2019/01/fnair-logo.png", "France Rein"},
                {"67", "HyperSupers","1","Créée en 2002, l’association HyperSupers – TDAH France aide les familles, adultes et enfants concernés par le trouble de Déficit de l’Attention / Hyperactivité (TDAH).\n" +
                        "\n" +
                        "Parmi ses missions :\n" +
                        "\n" +
                        "Informer les familles d’enfants ou les adultes présentant un trouble déficit de l’attention/hyperactivité.\n" +
                        "\n" +
                        "Être une force de proposition pour améliorer l’accès au soin, les délais de consultation et la prise en charge des patients présentant un TDAH\n" +
                        "Permettre aux personnes concernées par le TDAH de se rencontrer, pour pouvoir partager, échanger et s’entraider entre eux afin de surmonter leurs difficultés.\n" +
                        "Favoriser l’intégration, en organisant et coordonnant la solidarité multidisciplinaire nécessaire à la bonne intégration sociale et scolaire des enfants présentant ce trouble.\n" +
                        "Sensibiliser et former les professionnels de santé et de l’éducation qui sont en relation avec des personnes présentant un TDAH."  ,"https://hypersupers-tdah-france.france-assos-sante.org/wp-content/uploads/sites/131/2022/04/logo-hypersupers-tdah.png", "HyperSupers"},
                {"68", "JALMALV","6","Mouvement associatif qui agit pour que chaque personne gravement malade, même en fin de vie, soit considérée comme une personne à part entière, vivante et digne jusqu’à son dernier souffle.\n" +
                        "\n" +
                        "Un mouvement laïc, sans appartenance confessionnelle ou politique, sans but lucratif.\n" +
                        "\n" +
                        "Une Fédération qui s’engage :\n" +
                        "\n" +
                        "Pour que toutes les personnes gravement malades ou en fin de vie puisse être accompagnées là où elles se trouvent\n" +
                        "Pour soutenir les familles, les proches et les soignants\n" +
                        "Pour proposer un soutien aux personnes vivant un deuil\n" +
                        "Plus de 2 000 accompagnants bénévoles, formés et soutenus par leurs associations, interviennent à la demande sur le terrain, à domicile, à l’hôpital, en EHPAD."  ,"https://www.jalmalv-federation.fr/wp-content/uploads/2018/04/logo-jalmalv-quadri-1.png", "Jusqu’à la mort accompagner la vie"},
                {"69", "La Croix Bleue", "7","Association loi 1901, reconnue d’utilité publique depuis 1922 se veut ouverte à TOUS sans distinction pour venir en aide aux personnes en difficulté avec l’alcool et autres addictions ainsi qu’aux personnes de leur entourage.\n" +
                        "Elle est indépendante du corps médical et social, de toute organisation politique, syndicale confessionnelle, tout en entretenant des relations suivies avec les uns et les autres.\n" +
                        "\n" +
                        "Elle dispose :\n" +
                        "\n" +
                        "D’un siège : secrétariat national et accueil téléphonique\n" +
                        "De 70 sections réparties en France\n" +
                        "D’un camping sans alcool en Ardèche\n" +
                        "D’un journal trimestriel « Le Libérateur »\n" +
                        "De tracts, d’affiches, brochures, dossiers, livres\n" +
                        "D’un centre de Postcure" ,"https://www.croixbleue.fr/local/cache-vignettes/L220xH96/siteon0-fa04f.jpg?1688112334", "La Croix Bleue"},
                {"70", "La CSF","7","La Confédération Syndicale des Familles a pour but d’assurer, au point de vue matériel et moral, la défense et la représentation des intérêts généraux des familles quelle que soit leur situation juridique et sociale ou leur nationalité.\n" +
                        "\n" +
                        "C’est une association d’usagers du système de santé agréée, et c’est à ce titre qu’elle représente les usagers dans différentes instances au sein d’une vingtaine de départements."  ,"https://www.la-csf.org/wp-content/uploads/2018/07/logo-csf.png", "Confédération Syndicale des Familles"},
                {"71", "LCC", "7","Premier financeur associatif de la recherche contre le cancer, la Ligue contre le cancer est une organisation non-gouvernementale indépendante reposant sur la générosité du public et sur l’engagement de ses militants. Forte de 600 000 adhérents et de 13 800 bénévoles, la Ligue est un mouvement populaire organisé en une fédération de 103 comités départementaux. Ensemble, ils luttent dans quatre directions complémentaires : chercher pour guérir, prévenir pour protéger, accompagner pour aider, mobiliser pour agir.\n" +
                        "\n" +
                        "Aujourd’hui, la Ligue fait de la lutte contre le cancer un enjeu sociétal rassemblant le plus grand nombre possible d’acteurs sanitaires mais aussi économiques, sociaux ou politiques sur tous les territoires. En brisant les tabous et les peurs, la Ligue contribue au changement de l’image du cancer et de ceux qui en sont atteints." ,"https://www.ligue-cancer.net/themes/lncc/logo_LNCC.png", "Ligue Contre le Cancer"},
                {"72", "Le Lien","2","Le cœur de mission du LIEN est de défendre les victimes d’accidents médicaux. Son action s’exerce dans le cadre de la lutte contre les infections nosocomiales et les accidents médicaux, qu’il s’agisse d’erreurs, de fautes ou d’aléas.\n" +
                        "\n" +
                        "L’Association aide les patients en cas de difficultés pour accéder à leur dossier médical ou pour engager une demande d’indemnisation en cas de dommages de soin et choisir la voie la plus adaptée à chaque cas pour obtenir une juste réparation de l’ensemble des préjudices de soins.\n" +
                        "\n" +
                        "L’accompagnement des patients pour optimiser la préparation et la présentation du dossier devant une commission régionale amiable d’indemnisation est gratuit pour tout adhérent. En cas de besoin, une étude de dossier peut être réalisée par un médecin conseil de victimes agréé par l’association."  ,"https://www.france-assos-sante.org/wp-content/uploads/2019/01/association-le-lien-200x136.png", "Le Lien"},
                {"73", "Le Planning familial", "7","Créée en 1956 sous le nom de « La maternité heureuse », l’association réunissait des femmes et des hommes bien décidés à faire changer la loi de 1920 qui interdisait l’avortement, ainsi que l’utilisation et la diffusion de tout moyen contraceptif en France.\n" +
                        "En 1960, l’association devient le « Mouvement Français pour Le Planning Familial » (MFPF) dit « Le Planning Familial » et adhère à l’International Planned Parenthood Federation (IPPF).\n" +
                        "\n" +
                        "Le Planning Familial est un mouvement militant qui prend en compte toutes les sexualités, défend le droit à la contraception, à l’avortement et à l’éducation à la sexualité. Il dénonce et combat toutes les formes de violences, lutte contre le SIDA et les IST, contre toutes les formes de discrimination et contre les inégalités sociales.\n" +
                        "\n" ,"https://www.planning-familial.org/themes/custom/customer/images/logo.png", "Le Planning familial"},
                {"74", "LPFP","6","Depuis 1946, les Petits Frères des Pauvres accompagnent les personnes âgées souffrant d’isolement, prioritairement les plus démunies.\n" +
                        "\n" +
                        "Par nos actions, nous recréons des liens leur permettant de retrouver une dynamique de vie.\n" +
                        "\n" +
                        "Par notre voix, nous incitons la société à changer de regard sur la vieillesse, nous témoignons des situations inacceptables que nous rencontrons, nous alertons les pouvoirs publics sur la nécessité d’agir, nous favorisons l’engagement citoyen, nous proposons des réponses nouvelles.\n" +
                        "\n" +
                        "Nous sommes l’association la plus importante, avec notre Fondation et nos établissements, spécialisée sur les problématiques de l’isolement des personnes âgées.\n" +
                        "\n" +
                        "Aujourd’hui en France, 2 millions d’aînés souffrent d’isolement. 530 000 personnes âgées sont en état de « mort sociale », privées de liens et des plaisirs simples et essentiels de la vie."  ,"https://petits-freres-des-pauvres.france-assos-sante.org/wp-content/uploads/sites/56/2019/07/Logo_PFP_Horizontal_signature_Posi_Rouge_RVB.png", "Les Petits Frères des Pauvres"},
                {"75", "Marfans", "1","L’association française des syndromes de Marfan et Apparentés, créée en 1995, a pour principaux objectifs de faire connaître la maladie de Marfan, d’aider et soutenir les personnes atteintes de cette maladie et leur famille ; informer les malades de leurs droits et des démarches administratives nécessaires à la reconnaissance de leurs droits ; représenter les adhérents auprès des pouvoirs publics et des associations étrangères similaires notamment via son réseau d’aide et de soutien et ses diverses publications." ,"https://marfans.france-assos-sante.org/wp-content/uploads/sites/54/2019/01/logo-marfans.png", "Marfans"},
                {"76", "Priartem","7","L’association PRIARTEM (Pour Rassembler, Informer et Agir sur les Risques liés aux Technologies ElectoMagnétiques) est la première ONG créée sur la problématique « ondes-santé-environnement ». Priartem agit depuis 2000 pour la protection de la santé et de l’environnement face aux risques liés à l’exposition aux ondes électromagnétiques."  ,"https://www.priartem.org/squelettes/images/bandeau-haut2.jpg", "Priartem"},
                {"77", "Renaloo","1", "Renaloo a été créé en 2002, sous la forme d’un blog puis est devenu une association de patients en 2008.\n" +
                        "\n" +
                        "Renaloo dispose de l’agrément national des associations d’usagers du système de santé\n" +
                        "\n" +
                        "L’association développe de nombreuses activités, sur et hors internet, pour porter de la manière la plus efficace possible ses valeurs de soutien et d’empowerment des personnes qui vivent avec une maladie rénale, la dialyse, la greffe, de défense de leurs droits et de leurs intérêts et d’amélioration de leur prise en charge et de leur vie.\n" +
                        "\n" +
                        "La vie de l’association repose notamment sur l’engagement de l’équipe de Renaloo, constituée de personnes vivant avec une maladie rénale et de proches, qui ont choisi de s’impliquer." ,"https://renaloo.fr/wp-content/uploads/2020/04/LOGO1.png", "Renaloo"},
                {"78", "Réseau D.E.S. France", "2","Le D.E.S. qu’est-ce que c’est ?\n" +
                        "C’est un oestrogène de synthèse (le Diéthylstilbestrol ou D.E.S. en abrégé), prescrit durant la grossesse, espérant éviter aux femmes des fausses-couches ou autres accidents de grossesse. Il s’est avéré inefficace. En France, le D.E.S. a été prescrit à 200 000 femmes ; 160 000 enfants nés sont concernés. Dans le monde, le D.E.S. a été administré à des millions de femmes, pour cette indication.\n" +
                        "Toutes les personnes concernées ne vivent pas nécessairement avec des conséquences, mais doivent rester vigilantes.\n" +
                        "\n" +
                        "Vous êtes concerné.e si …\n" +
                        "1 Enceinte entre 1948 et 1977, le DES vous a été prescrit : vous êtes une “maman D.E.S.“\n" +
                        "2 Vous êtes né.e avant 1978 : vous pouvez avoir été exposé.e in utero, et donc être une “fille D.E.S.“ou un “fils D.E.S.“\n" +
                        "3 L’un de vos parents a été exposé in utero au D.E.S., vous êtes un “petit-fils D.E.S.“ ou une “petite-fille D.E.S.“\nAprès l’existence de deux associations (DES Action France, Info-DES), création de l’association Réseau D.E.S. France en octobre 1994, par des membres issues d’Info-DES, dont Anne Levadou et Claire Sarri, actuellement membres du Conseil d’administration ; les autres co-fondateurs sont adhérents et contacts locaux. L’association est membre de DES ACTION INTERNATIONAL. Dès 1999, elle s’est dotée d’un Conseil Scientifique.\n" +
                        "\n" +
                        "Depuis fin 2016, Réseau D.E.S. France bénéficie d’un agrément national, accordé par le Ministère en charge de la santé (n° N2016AG0069).\n" +
                        "\n" +
                        "Notre ligne de conduite :\n" +
                        "Informer\n" +
                        "• Nous apportons une réponse par une information scientifiquement validée, régulièrement actualisée, des conséquences du D.E.S. C’est essentiel pour organiser la prévention et réduire les conséquences.\n" +
                        "• Notre histoire démontre que la pharmacovigilance doit être indépendante et menée sur le long terme.\n" +
                        "Soutenir\n" +
                        "Nous organisons un réseau d’entraide et de partage pour permettre de sortir de l’isolement.\n" +
                        "Coopérer\n" +
                        "Nous coopérons avec les professionnels et institutions de santé, les élus, les autres associations DES dans le monde… Pour améliorer la prise en charge des\n" +
                        "personnes concernées." ,"https://www.des-france.org/wp-content/uploads/2021/10/Logo-DES-france-arbre.png", "Réseau Diéthylstilbestrol France"},
                {"79", "RES", "5","Créé en 2009, le Réseau Environnement Santé (RES) a été l’instigateur de l’interdiction du Bisphénol A dans les biberons en France, puis dans l’ensemble de l’Union Européenne. Parmi ses autres actions significatives d’alors, le RES a été à l’initiative de la Stratégie Nationale Perturbateurs Endocriniens (SNPE), actée en 2014 et confirmée en 2019, avec l’objectif principal de « réduire l’exposition de la population ».\n" +
                        "\n" +
                        "La campagne « Villes et Territoires Sans Perturbateurs Endocriniens » vise à mobiliser les collectivités territoriales sur cet objectif. Avec l’appui de ses délégations régionales et avec l’objectif de mettre la Santé Environnementale au cœur des politiques publiques, le RES organise régulièrement des colloques avec des associations de malades (thyroïdie, infertilité , AVC-Jeunes, bientôt obésité, …), pour mettre dans le débat public les données scientifiques montrant la réalité concrète de l’ « épidémie mondiale de maladies chroniques » (OMS), ainsi que différents sujets thématiques (petite enfance, normes dans les eaux, bientôt habitat/urbanisme, …), avec l’objectif de proposer des actions aux décideurs.\n" +
                        "\n" +
                        "De plus, cette dynamique de plaidoyer qui constitue l’ADN du RES et illustrée par différents communiqués et réactions à l’actualité, ainsi que diverses auditions et rencontres institutionnelles, permet une démarche transversale pour tous les acteurs de la santé impliqués dans la prévention et la promotion de la santé, secteurs qui doivent être revisités à l’aune de la santé environnementale.\n" +
                        "\n" +
                        "La crise sanitaire actuelle, renforcée par la pandémie du Covid 19, montre que ce dernier est un révélateur des maladies chroniques (i.e. obésité en premier lieu, mais également diabète, HTA et pathologies cardio-vasculaires, etc.) d’autant en prenant en compte les inégalités sociales (pauvreté, ethnie, …)." ,"https://www.reseau-environnement-sante.fr/wp-content/uploads/2018/04/logo.jpg", "Réseau Environnement Santé"},
                {"80", "Schizo-oui", "4","Schizo-oui est une association d’usagers en santé mentale née en janvier 1998. A cette époque, seulement un schizophrène sur cinq avait connaissance de son diagnostic. Or, cette maladie touche 1% de la population toutes catégories sociales confondues. Il est nécessaire de s’unir pour la combattre en ayant des objectifs précis. C’est la volonté de Schizo-oui, association qui s’organise. Schizo-oui est une association apolitique et indépendante de tout groupe de pression.\n" +
                        "\n" ,"https://www.schizo-oui.com/wp-content/uploads/2024/02/logo_schizooui.png", "Schizo-oui"},
                {"81", "SOS HF","1","L’Association « SOS HEPATITES FEDERATION », fondée en novembre 1998, regroupe des associations ayant pour but la prévention, l’information, la solidarité, la défense de toutes les personnes concernées par les hépatites virales, les maladies du foie, quels que soient les virus et les modes de contamination, ainsi que la promotion de la recherche."  ,"https://soshepatites.org/wp-content/themes/soshepatitesV2/img/logo-federation-sos-hepatites.png", "SOS hepatites federation"},
                {"82", "TRANSHÉPATE", "1","L’association TRANSHÉPATE est née en 1985 d’un élan de solidarité des premiers malades ayant bénéficié d’une greffe de foie désireux d’aider les malades en attente de transplantation. Notre association est actuellement implantée dans quasiment tous les centres de transplantation hépatique et regroupe en son sein toutes les grandes associations régionales de greffés du foie.\n" +
                        "\n" +
                        "Notre revue HÉPAT-INFOS diffuse largement une information que nous voulons de qualité parmi les transplantés, les malades hépatiques et le milieu médical. Depuis le 1er février 1997 TRANSHÉPATE s’est ouvert, et maintenant son champ d’action couvre l’ensemble des malades atteints d’une déficience hépatique sévère, et en particulier les malades atteints par les hépatites virales. TRANSHÉPATE a obtenu le bénéfice des articles 200-3 et 238 bis-2 du Code Général des impôts.\n" +
                        "\n" +
                        "L’Association est reconnue en qualité d’association à but exclusif d’assistance voire de bienfaisance." ,"https://www.transhepate.org/wp-content/uploads/2021/11/logo-transephate.jpg", "Transhépate"},
                {"83", "UAFLMV","7","Groupement d’associations d’anciens malades guéris d’un cancer, l’UNION est concernée par une population atteinte d’une affection « orpheline » méconnue des organismes officiels du fait de son importance réduite. Selon les données de l’INCa (Institut national du cancer), 3 220 laryngectomies totales ont été pratiquées en 2017, dont 2 746 chez les hommes et 474 chez les femmes (soit environ 15 %). L’UNION existe parce que quelques laryngectomisés, opérés dans les années 1950, confrontés à l’absence de soutien, ont surmonté l’épreuve de la mutilation et réussi à se réinsérer. Aujourd’hui, l’UNION regroupe 21 associations régionales toutes animées par des bénévoles qui, avant d’être eux-mêmes réinsérés ont suivi toutes les étapes de ce processus.\n" +
                        "\n" +
                        "Leur objectif est d’inciter les futurs ou nouveaux opérés à surmonter l’épreuve à laquelle ils sont confrontés en suivant leur exemple et leurs conseils.\n" +
                        "\n"  ,"https://www.mutiles-voix.com/wp-content/uploads/2019/03/UN_logo-266x300.png", "Union des associations françaises de laryngectomisés et mutilés de la voix"},
                {"84", "UFAL","7","L’Union des FAmilles Laïques est une association familiale au sens de l’article L211-1 du Code de l’action sociale et des familles et l’un des sept mouvements à recrutement général de l’Union nationale des Associations Familiales (UNAF).\n" +
                        "\n" +
                        "Le rôle de l’UFAL est de :\n" +
                        "• définir et de défendre les droits et les intérêts matériels et moraux des familles adhérentes regroupées par les associations adhérentes, de les représenter en toutes circonstances, d’agir en leur nom et d’intervenir, notamment auprès des pouvoirs publics, des organismes semi-publics, des collectivités et des institutions publiques ;\n" +
                        "• représenter toutes les catégories de familles vivant sur le territoire national et œuvrer auprès d’elles dans les domaines de la solidarité et la protection sociale, de la santé et de la prise en charge des malades, de la vieillesse, des revenus de remplacement, de l’aide sociale et de la lutte contre la précarité, les harcèlements, les discriminations et les exclusions."  ,"https://www.ufal.org/wp-content/uploads/2022/04/logo-site.png", "Union des Familles Laïques"},
                {"85", "UFC-Que Choisir", "7","Expert, indépendant, militant, l’UFC-Que Choisir est une association à but non lucratif. Enquêtes, tests, combats judiciaires, actions de lobbying : avec son réseau de plus de 150 associations locales, l’UFC-Que Choisir est au service des consommateurs pour les informer, les conseiller et les défendre." ,"https://ufc.france-assos-sante.org/wp-content/uploads/sites/39/2019/01/Logo_UFC_Que_Choisir-150x167.jpg", "UFC-Que Choisir"},
                {"86", "UNAF", "7","L’UNAF est une institution nationale chargée de promouvoir, défendre et représenter les intérêts de toutes les familles vivant sur le territoire français, quelles que soient leurs croyances ou leur appartenance politique.\n" +
                        "\n" +
                        "Union et non fédération d’associations, elle permet aux familles de s’exprimer, dans toute leur diversité, pour une politique familiale globale, innovante et forte.\n" +
                        "\n" +
                        "Elle anime le réseau des Unions Régionales des Associations Familiales (URAF) et des Unions Départementales des Associations Familiales (UDAF), et les appuie dans leurs missions institutionnelles et de services aux familles." ,"https://unaf.france-assos-sante.org/wp-content/uploads/sites/38/2019/07/Logo_Unaf.png", "Union nationale des associations familiales"},
                {"87", "UNAFAM","4","L’Unafam est une association reconnue d’utilité publique, qui accueille, écoute, soutient, forme, informe et accompagne les familles et l’entourage de personnes vivant avec des troubles psychiques depuis 1963. Elle compte plus de 14 000 adhérents.\n" +
                        "\n" +
                        "Depuis sa création l’Unafam concentre son action au profit de l’entourage des personnes vivant avec des troubles psychiques sévères, essentiellement des personnes atteintes de schizophrénie, de troubles bipolaires, de dépressions sévères, de psychoses graves et de troubles obsessionnels compulsifs. Depuis plus récemment, l’Unafam reçoit les parents d’enfants et d’adolescents ayant des troubles psychologiques, des troubles psychiques ou des troubles du comportement."  ,"https://unafam.france-assos-sante.org/wp-content/uploads/sites/37/2019/01/logo-unafam-200x200.jpg", "Union nationale de familles et amis de personnes malades et/ou handicapées psychiques"},
                {"88", "UNAFTC","3","L’Union Nationale des Associations de Familles de Traumatisés crâniens et de Cérébro-lésés a été créée en 1986.\n" +
                        "\n" +
                        "Il s’agit d’une association loi 1901 à but non lucratif reconnue d’intérêt général rassemblant en son sein, des personnes morales :\n" +
                        "\n" +
                        "52 AFTC Associations de Familles de Traumatisés crâniens et de Cérébro-lésés\n" +
                        "99 établissements et services dédiés à l’accueil des personnes cérébro-lésées\n" +
                        "45 GEM Groupes d’Entraide Mutuelle portés par des associations de personnes cérébro-lésées"  ,"https://www.cerebrolesion.org/plugins/ParvisPlugin/images/navigation/logo-unaftc.png", "Union nationale des associations de familles de traumatisés crâniens et cérébro-lésés"},
                {"89", "UNAPECLE","6","L’UNAPECLE est l’Union des Associations de Parents d’Enfants atteints de Cancer ou LEucémie. Elle est composée d’associations de parents et de proches qui sous des formes souvent différentes ont un même objet social : Aider les familles d’enfants atteints de cancer ou de leucémie.\n" +
                        "\n" +
                        "Nos objectifs\n" +
                        "Ses objectifs, rappelés dans la charte que toutes les associations membres doivent signer, sont les suivants :\n" +
                        "\n" +
                        "Unir, fédérer et promouvoir les associations d’aide aux enfants et à leurs familles en vue de coordonner leurs actions communes.\n" +
                        "Favoriser l’échange de savoir-faire entre les associations membres.\n" +
                        "Représenter auprès des pouvoirs publics et de toutes les instances compétentes, toutes les fois qu’une action collective doit être exercée, les associations qu’elle fédère.\n" +
                        "Favoriser une meilleure communication, y compris dans le domaine de la recherche scientifique et médicale et sensibiliser et informer sur les problèmes posés par les cancers de l’enfant et de l’adolescent."  ,"https://imgs.search.brave.com/-t9tZxC6KQPMXhcXEaaqiDnS422wki-tGzJzDum7LmU/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly9wZWRp/YXRyaWUuZS1jYW5j/ZXIuZnIvdmFyL3Bl/ZGlhdHJpZS9zdG9y/YWdlL2ltYWdlcy85/LzIvMi82LzQ2MjI5/LTEtZnJlLUZSL3Vu/YXBlY2xlLnBuZw", "Union nationale des Associations de parents d’enfants atteints de cancer ou leucémie"},
                {"90","Unapei ",  "3","À l’Unapei, nous sommes 900 000 à nous battre au quotidien pour faire évoluer la société.\n" +
                        "\n" +
                        "Familles, amis, personnes handicapées, professionnels, soignants, aidants, bénévoles… Nous sommes tous engagés pour construire une société solidaire et inclusive, respectueuse des différences et du libre arbitre des personnes handicapées intellectuelles, autistes, polyhandicapées et porteuses de handicap psychique.\n" +
                        "\n" +
                        "Avec 550 associations, partout en France, l’Unapei est le principal mouvement associatif français.", "https://www.unapei.org/wp-content/themes/wext/assets/img/logo_unapei.png", "Union nationale des associations de parents, de personnes handicapées mentales et de leurs amis"},
                {"91"," VLM" , "1","Créée en 1965 par des parents de jeunes patients et des soignants, Vaincre la Mucoviscidose, reconnue d’utilité publique, est le premier financeur privé de la recherche en mucoviscidose en France.\n" +
                        "\n" +
                        "Vaincre la Mucoviscidose accompagne les malades et leur famille dans chaque aspect de leur vie bouleversée par la mucoviscidose.", "https://www.vaincrelamuco.org/sites/all/themes/custom/vlm/images/vlm_logo.png", "Vaincre la Mucoviscidose"},
                {"92","Vivre comme avant"  ,"1","A Vivre Comme Avant, nous tenons à ce qu’aucune femme n’ait à affronter, sans accompagnement, le cancer du sein.\n" +
                        "Nous souhaitons que chaque femme atteinte d’un cancer du sein trouve une alliée :\n" +
                        "\n" +
                        "qui saura l’écouter, la comprendre, l’accompagner pour l’aider à passer au mieux le cap de l’hospitalisation et des traitements\n" +
                        "qui l’encouragera dans les traitements et les suivis médicaux\n" +
                        "qui, ne serait-ce que le temps d’une rencontre ou d’un échange téléphonique, modifiera la vision de son avenir et lui donnera l’espoir de retrouver une qualité de vie satisfaisante après la maladie", "https://vivre-comme-avant.france-assos-sante.org/wp-content/uploads/sites/138/2022/10/Octobre-Rose-Vivre-Comme-Avant-logo-e1665496802729.png", "Vivre comme avant"},
                {"93","VMEH"  ,"3","La Fédération regroupe 82 associations déclarées loi de 1901 gérant 470 sections locales. Elle est reconnue d’Utilité Publique par décret du 09.01.2007.\n" +
                        "L’association compte 6000 BÉNÉVOLES assurant 2.000.000 de VISITES dans un millier d’établissements de santé et de maisons de retraite.", "https://imgs.search.brave.com/xiSKC1axZJNQygfgqVaR9pN5J5RRreCn0zvyiebaMDw/rs:fit:500:0:0:0/g:ce/aHR0cHM6Ly91cGxv/YWQud2lraW1lZGlh/Lm9yZy93aWtpcGVk/aWEvY29tbW9ucy9k/L2RjL1ZNRUhfUlZC/LnN2Zw", "Visite des Malades dans les Etablissements Hospitaliers"}
        };

        // Ajout des associations dans Firestore
        for (String[] assoc : associations) {
            String id = assoc[0];
            String name = assoc[1];
            String categorie = assoc[2];
            String description = assoc[3];
            String logoUrl = assoc[4];
            String intitule = assoc[5];

            Map<String, Object> data = new HashMap<>();
            data.put("name", name);
            data.put("categorie", categorie);
            data.put("description", description);
            data.put("logoUrl", logoUrl);
            data.put("intitule", intitule);

            db.collection("associations").document(id)
                    .set(data)
                    .addOnSuccessListener(aVoid -> Log.d("Firestore", "Asso ajoutée avec succès"))
                    .addOnFailureListener(e -> Log.w("Firestore", "Erreur lors de l'ajout de l'asso", e));
        }
    }
}