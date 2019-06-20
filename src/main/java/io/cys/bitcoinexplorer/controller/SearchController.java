package io.cys.bitcoinexplorer.controller;

import com.github.pagehelper.PageInfo;
import io.cys.bitcoinexplorer.dto.SearchListDTO;
import io.cys.bitcoinexplorer.service.BitcoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

   @Autowired
   private BitcoinService bitcoinService;

    @GetMapping("/searchList")
    public  List<SearchListDTO> searchList(
            @RequestParam(required = false) Integer height,
            @RequestParam(required = false) String txhash,
            @RequestParam(required = false) String address){

        List<SearchListDTO> keywordSearch = bitcoinService.getSearchByTransactionDetail(height,txhash,address);

        return  keywordSearch;
    }


}
