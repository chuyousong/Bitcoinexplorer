package io.cys.bitcoinexplorer.controller;

import io.cys.bitcoinexplorer.dto.BlockGetDTO;
import io.cys.bitcoinexplorer.dto.BlockListDTO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/block")
public class BlockController {

    @GetMapping("/getRecentBlocks")
    public List<BlockListDTO> getRecentBlocks(){
        ArrayList<BlockListDTO> blockListDTOS = new ArrayList<>();

        BlockListDTO blockListDTO = new BlockListDTO();
        blockListDTO.setBlockhash("00000000000000000024b3d4793dcbba032d3fc28a0d77a37d466b956fb68aa5");
        blockListDTO.setHeight(580644);
        blockListDTO.setTime(new Date());
        blockListDTO.setNumberOfTransactions(2867);
        blockListDTO.setSize(1257767);
        blockListDTO.setRelayedy("SlushPool");
        blockListDTOS.add(blockListDTO);

        BlockListDTO blockListDTO2 = new BlockListDTO();
        blockListDTO2.setBlockhash("00000000000000000001ce5f88601a311f1c73c0073a15fe4e5956da7fbcd78b");
        blockListDTO2.setHeight(580643);
        blockListDTO2.setTime(new Date());
        blockListDTO.setRelayedy("AntPool");
        blockListDTO2.setNumberOfTransactions(538);
        blockListDTO2.setSize(1322496);
        blockListDTOS.add(blockListDTO2);
        return blockListDTOS;
    }

    @GetMapping("/getByBlockhash")
    public BlockGetDTO getByBlockhash(@RequestParam String blockhash){
        BlockGetDTO blockGetDTO = new BlockGetDTO();
        blockGetDTO.setNumberOfTransactions(2867);
        blockGetDTO.setOutputTotal(14903.18388402);
        blockGetDTO.setEstimatedTransactionVolume((int) 1114.30298937);
        blockGetDTO.setTransactionFees(0.8105428);
        blockGetDTO.setHeight(580770);
        blockGetDTO.setTime(new Date());
        blockGetDTO.setRelayedy("SlushPool");
        blockGetDTO.setDifficulty(7409399249090.25);
        blockGetDTO.setBits(388365571);
        blockGetDTO.setSize(1225464);
        blockGetDTO.setWeight((float) 3993.093);
        blockGetDTO.setVersion("0x2000E000");
        blockGetDTO.setNonce(576074419);
        blockGetDTO.setBlockReward(12.5);
        blockGetDTO.setBlockhash("00000000000000000025c889729b9f97cb3fc683742608fd61c7e481a7e2c951");
        blockGetDTO.setPreviousBlock("000000000000000000101451f546c34c144066c1f7d4e360de321a0bbf43dedb");


        BlockGetDTO blockGetDTO2 = new BlockGetDTO();
        blockGetDTO2.setNumberOfTransactions(538);
        blockGetDTO2.setOutputTotal(1647.45939539);
        blockGetDTO2.setEstimatedTransactionVolume((int) 96.41705109);
        blockGetDTO2.setTransactionFees(0.18751074);
        blockGetDTO2.setHeight(580769);
        blockGetDTO2.setTime(new Date());
        blockGetDTO2.setRelayedy("AntPool");
        blockGetDTO2.setDifficulty(7409399249090.25);
        blockGetDTO2.setBits(388365571);
        blockGetDTO2.setSize(1773224 );
        blockGetDTO2.setWeight((float)3992.765);
        blockGetDTO2.setVersion("0x20400000");
        blockGetDTO2.setNonce(	657882304);
        blockGetDTO2.setBlockReward(12.5);
        blockGetDTO2.setBlockhash("000000000000000000101451f546c34c144066c1f7d4e360de321a0bbf43dedb");
        blockGetDTO2.setPreviousBlock("00000000000000000006a0673f90d900aefe5f7bef705f7dbdabe9b7077e06dd");
        blockGetDTO2.setNextBlock("00000000000000000025c889729b9f97cb3fc683742608fd61c7e481a7e2c951");
        return  blockGetDTO2;
    }


    @GetMapping("/getByHeight")
    public BlockGetDTO getByHeight(@RequestParam Integer height){
        BlockGetDTO blockGetDTO = new BlockGetDTO();
        blockGetDTO.setNumberOfTransactions(2867);
        blockGetDTO.setOutputTotal(14903.18388402);
        blockGetDTO.setEstimatedTransactionVolume((int) 1114.30298937);
        blockGetDTO.setTransactionFees(0.8105428);
        blockGetDTO.setHeight(580770);
        blockGetDTO.setTime(new Date());
        blockGetDTO.setRelayedy("SlushPool");
        blockGetDTO.setDifficulty(7409399249090.25);
        blockGetDTO.setBits(388365571);
        blockGetDTO.setSize(1225464);
        blockGetDTO.setWeight((float) 3993.093);
        blockGetDTO.setVersion("0x2000E000");
        blockGetDTO.setNonce(576074419);
        blockGetDTO.setBlockReward(12.5);
        blockGetDTO.setBlockhash("00000000000000000025c889729b9f97cb3fc683742608fd61c7e481a7e2c951");
        blockGetDTO.setPreviousBlock("000000000000000000101451f546c34c144066c1f7d4e360de321a0bbf43dedb");


        BlockGetDTO blockGetDTO2 = new BlockGetDTO();
        blockGetDTO2.setNumberOfTransactions(538);
        blockGetDTO2.setOutputTotal(1647.45939539);
        blockGetDTO2.setEstimatedTransactionVolume((int) 96.41705109);
        blockGetDTO2.setTransactionFees(0.18751074);
        blockGetDTO2.setHeight(580769);
        blockGetDTO2.setTime(new Date());
        blockGetDTO2.setRelayedy("AntPool");
        blockGetDTO2.setDifficulty(7409399249090.25);
        blockGetDTO2.setBits(388365571);
        blockGetDTO2.setSize(1773224 );
        blockGetDTO2.setWeight((float)3992.765);
        blockGetDTO2.setVersion("0x20400000");
        blockGetDTO2.setNonce(	657882304);
        blockGetDTO2.setBlockReward(12.5);
        blockGetDTO2.setBlockhash("000000000000000000101451f546c34c144066c1f7d4e360de321a0bbf43dedb");
        blockGetDTO2.setPreviousBlock("00000000000000000006a0673f90d900aefe5f7bef705f7dbdabe9b7077e06dd");
        blockGetDTO2.setNextBlock("00000000000000000025c889729b9f97cb3fc683742608fd61c7e481a7e2c951");
        return  blockGetDTO2;
    }

}


