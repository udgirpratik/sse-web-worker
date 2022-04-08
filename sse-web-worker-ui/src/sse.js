import { updateStocksStore } from "./stock/stock-data-store";

const setUpSSE = (stockStore, setStockStore) => {
  const sse = new EventSource('http://localhost:8080/sse/prices',
    { withCredentials: true });
  
  sse.onmessage = e =>  {
    let stockObj = JSON.parse(e.data);
    let updatedStore = updateStocksStore(stockStore, stockObj.stocksData);
    let newMap = new Map(updatedStore)
    console.log(newMap)
    setStockStore(newMap);
    
  } 
  sse.onerror = () => sse.close();
  return () => {
    sse.close();
  };
};



export default setUpSSE;