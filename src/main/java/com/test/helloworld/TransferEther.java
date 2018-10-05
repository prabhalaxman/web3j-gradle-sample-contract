package com.test.helloworld;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Transfer;
import org.web3j.utils.Convert;

import java.math.BigDecimal;

public class TransferEther {
    private static final Logger log = LoggerFactory.getLogger(TransferEther.class);

    public static void main(String[] args) throws Exception {

        new TransferEther().run();
    }

    private void run() throws Exception {
        // We start by creating a new web3j instance to connect to remote nodes on the network.
        Web3j web3j = Web3j.build(new HttpService("http://<-- your ip address -->:port"));
        System.out.println("Connected to Ethereum client version: "
                + web3j.web3ClientVersion().send().getWeb3ClientVersion());
        Credentials credentials =
                WalletUtils.loadCredentials(
                        "<--Your account password-->",
                        "<--Your wallet file location -->");
        System.out.println("Credentials loaded");
        System.out.println("Sending Ether ..");

        TransactionReceipt transferReceipt = Transfer.sendFunds(
                web3j, credentials,
                "0xf1b2d6d1a450cefbf74d18db299c66a858d6db47",  // you can put any address here
                BigDecimal.valueOf(0.001), Convert.Unit.ETHER)  // 1 wei = 10^-18 Ether
                .sendAsync().get();
//        log.info("Transaction complete : "
//                + transferReceipt.getTransactionHash());

        System.out.println("Transaction complete : "
                + transferReceipt.getTransactionHash());
    }
}
