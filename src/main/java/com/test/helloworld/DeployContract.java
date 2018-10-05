package com.test.helloworld;

import generated.com.test.Greeter;
import org.web3j.abi.datatypes.Utf8String;
import org.web3j.crypto.Credentials;
import org.web3j.crypto.WalletUtils;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.core.methods.response.TransactionReceipt;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.Contract;
import org.web3j.tx.ManagedTransaction;

public class DeployContract {

    public static void main(String args[]) throws Exception {
        DeployContract.deployContract();
    }


    private static void deployContract() throws Exception {
        Web3j web3j = Web3j.build(new HttpService("http://<-- your ip address -->:port"));
        System.out.println("Connected to Ethereum client version: "
                + web3j.web3ClientVersion().send().getWeb3ClientVersion());
        Credentials credentials =
                WalletUtils.loadCredentials(
                        "<--Your account password-->",
                        "<--Your wallet file location -->");
        System.out.println("Credentials loaded");
//        log.info("Sending Ether ..");

        Greeter contract = Greeter.deploy(
                web3j, credentials, ManagedTransaction.GAS_PRICE, Contract.GAS_LIMIT,
                new Utf8String("Greetings to the blockchain world!")).send();

        Utf8String greeting = contract.greet().send();
        System.out.println(greeting.getValue());

        TransactionReceipt transactionReceipt =
                contract.newGreeting(new Utf8String("Testing ")).send();
        System.out.println(transactionReceipt.getTransactionHash());

        Utf8String newGreeting = contract.greet().send();
        System.out.println(newGreeting.getValue());
    }
}
