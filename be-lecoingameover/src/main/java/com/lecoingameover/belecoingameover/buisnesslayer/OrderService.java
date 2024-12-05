package com.lecoingameover.belecoingameover.buisnesslayer;

import com.lecoingameover.belecoingameover.presentationlayer.ConsoleResponseModel;

import java.util.List;

public interface OrderService {
    List<ConsoleResponseModel> getConsoles(String customerId);

}