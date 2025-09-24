import { useState, useEffect } from "react";
import axios from "axios";
import { useAllContext } from "../Context/ContextProvider";
import { ToastContainer, toast } from "react-toastify";
import "react-toastify/dist/ReactToastify.css";
import { Modal, Button } from "react-bootstrap";

function Language() {
  const { languages, setLanguages } = useAllContext();
  const [newLang, setNewLang] = useState("");

  const [showModal, setShowModal] = useState(false);
  const [editLangId, setEditLangId] = useState<number | null>(null);
  const [editLangName, setEditLangName] = useState("");

  // -------------------------
  // Fetch languages from backend
  // -------------------------
  useEffect(() => {
    axios
      .get("http://localhost:8080/api/lang/") // your Spring Boot GET endpoint
      .then((res) => setLanguages(res.data))
      .catch((err) => toast.error("Failed to fetch languages"+err));
  }, [setLanguages]);

  // -------------------------
  // Add new language
  // -------------------------
  const handleAdd = (e: React.FormEvent) => {
    e.preventDefault();
    if (!newLang.trim()) {
      toast.error("Please enter a language name!");
      return;
    }

    axios
      .post("http://localhost:8080/api/lang/", { language: newLang }) // POST endpoint
      .then((res) => {
        setLanguages([...languages, res.data]);
        toast.success(`${newLang} added successfully!`);
        setNewLang("");
      })
      .catch(() => toast.error("Failed to add language"));
  };

  // -------------------------
  // Delete language
  // -------------------------
  const handleDelete = (id: number) => {
    axios
      .delete(`http://localhost:8080/api/lang/${id}`)
      .then(() => {
        setLanguages(languages.filter((lang) => lang.id !== id));
        toast.info("Language deleted!");
      })
      .catch(() => toast.error("Failed to delete language"));
  };

  // -------------------------
  // Open edit modal
  // -------------------------
  const handleEdit = (id: number, name: string) => {
    setEditLangId(id);
    setEditLangName(name);
    setShowModal(true);
  };

  // -------------------------
  // Save edited language
  // -------------------------
  const handleSaveEdit = () => {
    if (!editLangName.trim()) {
      toast.error("Language name cannot be empty!");
      return;
    }

    axios
      .put(`http://localhost:8080/api/lang/${editLangId}`, { language: editLangName })
      .then((res) => {
        setLanguages(
          languages.map((lang) =>
            lang.id === editLangId ? res.data : lang
          )
        );
        toast.success("Language updated successfully!");
        setShowModal(false);
      })
      .catch(() => toast.error("Failed to update language"));
  };

  return (
    <div className="container">
      <h2>Manage Language</h2>

      {/* Add Language Form */}
      <form onSubmit={handleAdd}>
        <div className="row mb-3">
          <div className="col">
            <input
              type="text"
              placeholder="Enter Language Name"
              className="form-control"
              value={newLang}
              onChange={(e) => setNewLang(e.target.value)}
            />
          </div>
        </div>
        <div className="row mb-3 text-center">
          <div className="col">
            <button type="submit" className="btn btn-primary">
              Add Language
            </button>
          </div>
        </div>
      </form>

      {/* Language List */}
      <ul className="list-group mt-3">
        {languages.map((lang) => (
          <li
            key={lang.id}
            className="list-group-item d-flex justify-content-between align-items-center"
          >
            {lang.language}
            <div>
              <button
                className="btn btn-sm btn-warning me-2"
                onClick={() => handleEdit(lang.id, lang.language)}
              >
                Edit
              </button>
              <button
                className="btn btn-sm btn-danger"
                onClick={() => handleDelete(lang.id)}
              >
                Delete
              </button>
            </div>
          </li>
        ))}
      </ul>

      {/* Edit Modal */}
      <Modal show={showModal} onHide={() => setShowModal(false)}>
        <Modal.Header closeButton>
          <Modal.Title>Edit Language</Modal.Title>
        </Modal.Header>
        <Modal.Body>
          <input
            type="text"
            className="form-control"
            value={editLangName}
            onChange={(e) => setEditLangName(e.target.value)}
          />
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={() => setShowModal(false)}>
            Cancel
          </Button>
          <Button variant="primary" onClick={handleSaveEdit}>
            Save Changes
          </Button>
        </Modal.Footer>
      </Modal>

      <ToastContainer position="top-right" autoClose={3000} />
    </div>
  );
}

export default Language;
