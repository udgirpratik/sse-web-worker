const updateStocksStore = (stocksStore, stocks) => {
    if(stocksStore.size === 0) {
        stocks.forEach(stock =>
            stocksStore.set(stock.id , stock)
        );
        
    } else {
        mergeById(stocksStore, stocks)
    }
    return stocksStore

}

const mergeById = (store, data) => {
    data.forEach( it =>  {
            if(store.get(it.id) !== undefined){
                Object.assign(store.get(it.id), it ) 
            } else {
                store.set(it.id, it)
            }
        }
    );
};

export {updateStocksStore};