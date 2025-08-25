import React from 'react';
import './App.css'; 
import GroceryList from './ReactFiles/Lab1';
import Car from './ReactFiles/Lab2';
import Phone from './ReactFiles/Lab3';
import SweetsList from './ReactFiles/Lab4';
import Electronics from './ReactFiles/Lab5';
import CanteenMenu from './ReactFiles/Lab6';
import JuiceList from './ReactFiles/Lab7';
import Restaurant from './ReactFiles/Lab8';
import TempleList from './ReactFiles/Lab9';
import TailorShop from './ReactFiles/Lab10';
import FruitManager from './Day2ReactFiles/Lab11';
import TelevisionManager from './Day2ReactFiles/Lab12';
import MarriageForm from './Day2ReactFiles/Lab13';
import AccessoriesForm from './Day2ReactFiles/Lab14A';
import BakingItemsManager from './Day2ReactFiles/Lab14B';
import FlightTicket from './Day2ReactFiles/Lab15';
import MovieForm from './Day2ReactFiles/Lab16';

import Lab18 from './Day2ReactFiles/Lab18';
import Lab17 from './Day2ReactFiles/Lab17';




function App() {
  // Define the data for the groceries list here.
  const groceryItems = ['Rice', 'Wheat', 'Sugar', 'Milk', 'Oil'];
  
  return (
    <div className="App">

      {/*-------Lab1-------*/}
      <div>
        {/* Pass the groceryItems array to the 'items' prop of Lab1 */}
        <GroceryList items={groceryItems} />
      </div>
      <br></br>
      <br></br>
      {/*-------Lab2-------*/}
      <div>
        <Car brand="Toyota" model="Fortuner" color="Black" year="2022" />
      </div>

      {/*-------Lab3-------*/}
      <div>
        <Phone/>
      </div>
      
      {/*-------Lab4-------*/}
      <div>
        <SweetsList/>
      </div>
      <br></br>
      <br></br>
      
      {/*-------Lab5-------*/}
      <div>
        <Electronics/>
      </div>
      <br></br>
      <br></br>
      
      {/*-------Lab6-------*/}
      <div>
        <CanteenMenu
        canteenName="Campus Food Court"
        location="Block A, Ground Floor"
        openHours="8:00 AM - 8:00 PM"
      />
      </div>
      
      {/*-------Lab7-------*/}
      <div>
        <JuiceList/>
      </div>
      
      {/*-------Lab8-------*/}
      <div>
        <Restaurant/>
      </div>
      
      {/*-------Lab9-------*/}
      <div>
        <TempleList/>
      </div>
      
      {/*-------Lab10-------*/}
      <div>
        <TailorShop/>
      </div>
      {/*-------Lab11-------*/}
      <div>
        <FruitManager/>
      </div>
      {/*-------Lab12-------*/}
      <div>
        <TelevisionManager/>
      </div>
      {/*-------Lab13-------*/}
      <div>
        <MarriageForm/>
      </div>
      {/*-------Lab14A-------*/}
      <div>
        <AccessoriesForm/>
      </div>
      {/*-------Lab14B-------*/}
      <div>
        <BakingItemsManager/>
      </div>
      {/*-------Lab15-------*/}
      <div>
        <FlightTicket/>
      </div>
      {/*-------Lab16-------*/}
      <div>
        <MovieForm/>
      </div>
      {/*-------Lab17-------*/}
      <div>
        <Lab17/>
      </div>
      {/*-------Lab18-------*/}
      <div>
        <Lab18/>
      </div>
    </div>
  );
}

export default App;