package tn.essat.nlpchatbot.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.essat.nlpchatbot.entity.TiersPayant;
import tn.essat.nlpchatbot.service.TiersPayantService;

import java.util.List;

@Service
@Transactional
public class TiersPayantServiceImp implements TiersPayantService {

    @Override
    public TiersPayant getTiersPayantById(String num_transaction) {
        return null;
    }

    @Override
    public List<TiersPayant> getAllTiersPayants() {
        return List.of();
    }

    @Override
    public TiersPayant addTiersPayant(TiersPayant tiersPayant) {
        return null;
    }

    @Override
    public TiersPayant updateTiersPayant(TiersPayant tiersPayant) {
        return null;
    }

    @Override
    public void deleteTiersPayant(String num_transaction) {

    }
}
