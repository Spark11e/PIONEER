import NavBar from "./components/Navbar/Navbar";
import MainPage from "./pages/MainPage";
import './App.css';

const App = ()  => {
  return (
      <div className="wrapper">
        <NavBar/>
        <MainPage/>
      </div>
    
  );
}

export default App;
