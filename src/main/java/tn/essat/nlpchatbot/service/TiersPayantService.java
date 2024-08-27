package tn.essat.nlpchatbot.service;

import tn.essat.nlpchatbot.entity.TiersPayant;

import java.util.List;

public interface TiersPayantService {
    TiersPayant getTiersPayantById(String num_transaction);
    List<TiersPayant> getAllTiersPayants();
    TiersPayant addTiersPayant(TiersPayant tiersPayant);
    TiersPayant updateTiersPayant(TiersPayant tiersPayant);
    void deleteTiersPayant(String num_transaction);
    //List
}
