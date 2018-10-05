# web3j-gradle-sample-contract

Prerequisites : 

# Setup geth server if you wish to mine your system with ethereum network.Or you can use online source (I have used my local system)

# Setup solidity -Refer - https://solidity.readthedocs.io/en/v0.4.21/installing-solidity.html

# Install web3j CLI - https://docs.web3j.io/command_line.html

For Detailed reference you can visit - https://docs.web3j.io/index.html

# IDE for java development and execution if you required (I preferred IntelliJ IDEA)

# create two ether account or wallet here i have created only ether account refer - http://ethdocs.org/en/latest/account-management.html

# for testing purpose we need some ether to test - to get some ether follow the steps with https://metamask.io/

Now assuming you have setted up everything.Lets start creating smart contract and deploy in ethereum network

Create java project with gradle (you can use maven)

add compile ('org.web3j:core:3.5.0') in your gradle

Here we are going to do the following 

# Functionality

This application demonstrates a number of core features of web3j and Ethereum:

    * Connecting to a node on the Ethereum network
    * Loading an Ethereum wallet file
    * Sending Ether from one address to another
    * Deploying a smart contract to the network
    * Reading a value from the deployed smart contract
    * Updating a value in the deployed smart contract
    * Viewing an event logged by the smart contract
    
    # First lets focus on ether transfer from one account to another 



And update your java class file like my TransferEther.java class

Run your transfer ether java class you can see the ether transaction status in your console.

To test your account transaction details you can refer - https://ropsten.etherscan.io/

# Now lets work on contract creation and deploy 

first create one Greeter.sol under Contracts/solidity - for my example i have created here you can create anywhere inside the application directory and put the code as my Greeter.sol file

Once solidity compiler is installed, you can now compile the Greeter contract by executing the following command 

When i excuted this command i was in my project directory.It may vary based on your project structure

# solcjs solidity/Greeter.sol --bin --abi --optimize -o build/

Now in the build directory should have four files

Lets create Greeter.java class by using the following command

# web3j solidity generate --solidityTypes Contracts/build/greeter.bin Contracts/build/greeter.abi  -p com.test -o src/main/java/generated 

Now create DeployContract.java class like my sample and Run the class you can see the transaction hash.

Also to check all your transaction hash refer - https://ropsten.etherscan.io/ enter your address and you can see all the details like ether transfer and Contract creation.

 





