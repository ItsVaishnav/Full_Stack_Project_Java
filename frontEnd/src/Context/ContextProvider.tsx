import { createContext, useContext, useState } from "react";
import type { ReactNode } from "react";

// 1. Define the type for a single language
interface Language {
  id: number;
  language: string;
}

interface AllContextType {
  languages: Language[];
  setLanguages: React.Dispatch<React.SetStateAction<Language[]>>;
}

// 3. Create the context (initially undefined so TS enforces provider usage)
const AllContext = createContext<AllContextType | undefined>(undefined);

// 4. Provider component
export function AllContextProvider({ children }: { children: ReactNode }) {
  const [languages, setLanguages] = useState<Language[]>([
    { id: 1, language: "Java" },
    { id: 2, language: "Python" },
    { id: 3, language: "JavaScript" },
  ]);

  return (
    <AllContext.Provider value={{ languages, setLanguages }}>
      {children}
    </AllContext.Provider>
  );
}

// 5. Custom hook
export function useAllContext() {
  const context = useContext(AllContext);
  if (!context) {
    throw new Error("useAllContext must be used within AllContextProvider");
  }
  return context;
}
