import './App.css';
import React, { useState, useEffect } from 'react';
import setUpSSE from './sse';
import { StockList } from './stock/stock-list';


function App() {

  const stockStoreInitial = new Map();
  stockStoreInitial.set('NA', {id: 'NA', name : 'TO COME' , price : 0.0, volume: 0});
  const [stockStore, setStockStore] = useState(stockStoreInitial);
    
  useEffect(() => {
   setUpSSE(stockStore, setStockStore);
  }, []);

  
  console.log('render')
  return (
        <StockList stockStore={stockStore}/>
    
  );
}

export default App;
