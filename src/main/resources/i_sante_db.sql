CREATE TABLE IF NOT EXISTS  adherent (
    matricule BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    CIN VARCHAR(255) NOT NULL,
    nom VARCHAR(255) NOT NULL,
    prenom VARCHAR(255) NOT NULL,
    genre VARCHAR(255) NOT NULL,
    RIB_RIP VARCHAR(255) NOT NULL,
    matricule_fiscale VARCHAR(255) NOT NULL,
    date_de_naissance VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL
);
CREATE TABLE IF NOT EXISTS  admin (
    matricule_admin BIGINT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    gsm VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    nom VARCHAR(255) NOT NULL,
    prenom VARCHAR(255) NOT NULL
);
CREATE TABLE IF NOT EXISTS  malade_en_charge (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nom VARCHAR(255) NOT NULL,
    prenom VARCHAR(255) NOT NULL,
    CIN VARCHAR(255) NOT NULL,
    qualite VARCHAR(255) NOT NULL,
    matricule_adherent BIGINT NOT NULL,
    CONSTRAINT fk_adherent FOREIGN KEY (matricule_adherent) REFERENCES adherent(matricule) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE IF NOT EXISTS  dossier (
    num_consultation BIGINT AUTO_INCREMENT PRIMARY KEY,
    pharmacie BOOLEAN NOT NULL,
    radio BOOLEAN NOT NULL,
    analyses BOOLEAN NOT NULL,
    autre BOOLEAN NOT NULL,
    ticket_moderateur BIGINT NOT NULL,
    reste_a_payer_consultation FLOAT NOT NULL,
    malade_en_charge_id BIGINT NOT NULL,
    CONSTRAINT fk_maladeencharge FOREIGN KEY (malade_en_charge_id) REFERENCES malade_en_charge(id) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE IF NOT EXISTS  reclamation (
    id_reclamation BIGINT AUTO_INCREMENT PRIMARY KEY,
    statut VARCHAR(255) NOT NULL,
    text_reclamation TEXT NOT NULL,
    id_consultation BIGINT NOT NULL,
    id_admin BIGINT NOT NULL,
    CONSTRAINT fk_consultation FOREIGN KEY (id_consultation) REFERENCES dossier(num_consultation) ON DELETE CASCADE ON UPDATE CASCADE,
    CONSTRAINT fk_admin FOREIGN KEY (id_admin) REFERENCES admin(matricule_admin) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE IF NOT EXISTS  tiers_payant (
    num_transaction BIGINT AUTO_INCREMENT PRIMARY KEY,
    reste_a_payer_transaction FLOAT NOT NULL,
    totale_ordonnace FLOAT NOT NULL,
    type VARCHAR(255) NOT NULL,
    consultation_id BIGINT NOT NULL,
    CONSTRAINT fk_dossier FOREIGN KEY (consultation_id) REFERENCES dossier(num_consultation) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE IF NOT EXISTS  remboursement (
    id_remboursement BIGINT AUTO_INCREMENT PRIMARY KEY,
    num_transaction BIGINT NOT NULL,
    total_remboursement FLOAT NOT NULL,
    decision BOOLEAN NOT NULL,
    date_decision VARCHAR(255),
    CONSTRAINT fk_tierspayant FOREIGN KEY (num_transaction) REFERENCES tiers_payant(num_transaction) ON DELETE CASCADE ON UPDATE CASCADE
);
